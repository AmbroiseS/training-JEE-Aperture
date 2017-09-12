package fr.epf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valeur = request.getParameter("valeur");
		Gson gson = new Gson();

		if (valeur!= null) {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			
			if (valeur!="") {
				List<Member> members= memberDAO.getMemberbyName(valeur);
				if (members!=null && members.size()!=0) {				
					response.getWriter().write(gson.toJson(members));
					System.out.println(gson.toJson(members));
					System.out.println(String.valueOf(members.size()));
					
				}
				
			}else {
				response.getWriter().write("<message>" + gson.toJson(memberDAO.findAll()) + "</message>");	
			}
			
		
			
		}else {
			List<Member> members = memberDAO.findAll();
			List<Review> reviews = reviewDAO.findAll();

			List<Promotion> promotions = displayPromotion();

			request.setAttribute("counterMember", "" + members.size());
			request.setAttribute("counterPromo", "" + promotions.size());
			request.setAttribute("counterReview", "" + reviews.size());

			request.setAttribute("reviews", reviews);
			request.setAttribute("promotions", promotions);
			request.setAttribute("members2", gson.toJson(members));

			
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		
		
	}

	private List<Promotion> displayPromotion() {
		List<Promotion> promotions = promoDAO.findAll();
		List<List<Member>> membersOfPromotion = new ArrayList<>();
		for (int i = 0; i < promotions.size(); i++) {
			membersOfPromotion.add(memberDAO.findManyByPromotion(promotions.get(i).getName()));
			promotions.get(i).setPromotionSize(membersOfPromotion.get(i).size());
		}
		;
		return promotions;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
