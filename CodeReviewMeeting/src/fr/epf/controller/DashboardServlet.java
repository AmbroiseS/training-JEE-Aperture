package fr.epf.controller;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.epf.dao.MemberDAO;
import fr.epf.dao.PromotionDAO;
import fr.epf.dao.ReviewDAO;
import fr.epf.models.Member;
import fr.epf.models.Review;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private PromotionDAO promoDAO;
	@Inject
	private ReviewDAO reviewDAO;
	
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		List members = memberDAO.findAll();		
		List promos = promoDAO.findAll();
		Review[] reviews = reviewDAO.findAll();
		
		int membercount = members.size();
		int promocount = promos.size();
		int reviewcount = reviews.length;
					
		
		request.setAttribute("counterMember", ""+ membercount);
		request.setAttribute("counterPromo", ""+ promocount);
		request.setAttribute("counterReview", ""+ reviewcount);
		request.setAttribute("reviews", reviews);
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
