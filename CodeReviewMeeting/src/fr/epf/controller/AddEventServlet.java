package fr.epf.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.beans.EmailSessionBean;
import fr.epf.dao.MemberDAO;
import fr.epf.dao.PromotionDAO;
import fr.epf.dao.ReviewDAO;
import fr.epf.models.Member;
import fr.epf.models.Promotion;
import fr.epf.models.Review;



@WebServlet("/add_event")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EmailSessionBean emailBean;
	
	@Inject
	private ReviewDAO reviewDAO;
	@Inject
	private PromotionDAO promoDAO; 
	@Inject
	private MemberDAO memberDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Promotion> promotions = promoDAO.findAll();
		request.setAttribute("promotions", promotions);
		request.getRequestDispatcher("/WEB-INF/add_event.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Review review = parseReview(req);
		List<Review> promotionReviews= reviewDAO.checkSlotAvailability(review.getReviewPromotion(), review.getReviewDateTime(), 2); 
		List<Review> reviewerReviews= reviewDAO.checkReviewerAvailability(review.getReviewer(), review.getReviewDateTime(), 2); 		
		//check promotion availability 
		if(promotionReviews.size() >0) {
			req.setAttribute("error", "Impossible de créer la revue, la promotion a déjà une revue sur ce créneau.");		
			req.getRequestDispatcher("/WEB-INF/add_event.jsp").forward(req, resp);	
		}else {
			//check reviewer availability
			if(reviewerReviews.size() >0) {
				req.setAttribute("error", "Impossible de créer la revue, l'animateur a déjà une revue sur ce créneau.");		
				req.getRequestDispatcher("/WEB-INF/add_event.jsp").forward(req, resp);				
			}else {
			//get emails adress and send emails to all member of the promotion
			List<Member> promo = memberDAO.findManyByPromotion(review.getReviewPromotion());
			emailBean.sendEmail(review.getReviewName(), review.getReviewDateTime(),review.getDescription(), promo);	
			reviewDAO.save(review);
			resp.sendRedirect("dashboard");	
			}	
		}		
	}
	
	private Review parseReview(HttpServletRequest req) {
		String name = req.getParameter("name");
		String reviewer = req.getParameter("reviewer");
		String date = (String) req.getParameter("date") + " " + req.getParameter("time") + ":00";
		String promotion = req.getParameter("promotion");
		String description = req.getParameter("description");		
		return new Review(name, date, promotion, description, reviewer);
	}
}
