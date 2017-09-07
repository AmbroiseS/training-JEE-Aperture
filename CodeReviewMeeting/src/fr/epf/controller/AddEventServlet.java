package fr.epf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.ReviewDAO;
import fr.epf.models.Review;



@WebServlet("/add_event")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReviewDAO reviewDAO;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/add_event.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Review review = parseReview(req);		
		reviewDAO.save(review);
		resp.sendRedirect("index");
	}
	
	private Review parseReview(HttpServletRequest req) {
		String name = req.getParameter("name");
		String date = req.getParameter("date");
		String promotion = req.getParameter("promotion");
		return new Review(name, date, promotion);
	}

}
