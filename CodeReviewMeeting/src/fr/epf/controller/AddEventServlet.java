package fr.epf.controller;

import java.io.IOException;
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

		//get all the destinators
		String promotion = req.getAttribute("name").toString();
		List<Member> promo = memberDAO.findManyByPromotion(promotion);

		emailBean.sendEmail("Test Java EE", "21-09-12", "This is a test for java ee project", promo);
		reviewDAO.save(review);
		resp.sendRedirect("dashboard");
	}
	
	private Review parseReview(HttpServletRequest req) {
		String name = req.getParameter("name");
		String date = (String) req.getParameter("date") + " " + req.getParameter("time");
		String promotion = req.getParameter("promotion");
		String description = req.getParameter("description");		
		return new Review(name, date, promotion, description);
	}

}
