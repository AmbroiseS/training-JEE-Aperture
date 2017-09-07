package fr.epf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.PromotionDAO;
import fr.epf.models.Promotion;

@WebServlet("/add_promotion")
public class AddPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PromotionDAO promotionDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/add_promotion.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Promotion promotion = parsePromotion(req);		
		promotionDAO.save(promotion);
		resp.sendRedirect("index");
	}
	
	private Promotion parsePromotion(HttpServletRequest req) {
		String name = req.getParameter("name");
		return new Promotion(name);
	}

}
