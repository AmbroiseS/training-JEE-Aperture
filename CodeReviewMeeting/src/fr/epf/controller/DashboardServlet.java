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


import fr.epf.dao.*;
import fr.epf.models.*;

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
		
		Promotion[] promotions = promoDAO.findAll();
		
		ArrayList<Member> members= new ArrayList<>();
		if (memberDAO != null)
			 members = memberDAO.findAll();		

		Review[] reviews = reviewDAO.findAll();
		
		int membercount = members.size();
		int promocount = promotions.length;
		int reviewcount = reviews.length;

		
		request.setAttribute("counterMember", ""+ membercount);
		request.setAttribute("counterPromo", ""+ promocount);
		request.setAttribute("counterReview", ""+ reviewcount);
		
		request.setAttribute("reviews", reviews);
		request.setAttribute("promotions", promotions);
		request.setAttribute("listMembers", members);

		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
