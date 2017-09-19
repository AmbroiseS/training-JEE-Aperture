package fr.epf.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.PromotionDAO;
import fr.epf.dao.ReviewDAO;
import fr.epf.models.Promotion;
import fr.epf.models.Review;

@WebServlet("/counter_to_next_review")
public class CounterToNextReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private PromotionDAO promoDAO;
	@Inject
	private ReviewDAO reviewDAO;
	
    public CounterToNextReview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String promotion = (String) request.getParameter("promotion");
		try {
			Review nextReview = reviewDAO.findNextByPromotion(promotion);
			request.setAttribute("nextReview", nextReview);
		}catch(EJBException e) {
		}
		List<Promotion> promotions = promoDAO.findAll();
		request.setAttribute("promotions", promotions);
		request.setAttribute("selectedPromotion", promotion);
		request.getRequestDispatcher("/WEB-INF/counter.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String promotion = (String) request.getParameter("promotion");
		try {
			Review nextReview = reviewDAO.findNextByPromotion(promotion);			
			request.setAttribute("nextReview", nextReview);
		}catch(EJBException e) {
		}
		request.setAttribute("promotion", promotion);
      	doGet(request, response);
	}

}
