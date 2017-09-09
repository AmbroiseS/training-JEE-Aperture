package fr.epf.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.MemberDAO;
import fr.epf.dao.PromotionDAO;
import fr.epf.models.Member;
import fr.epf.models.Promotion;


@WebServlet("/add_member")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private PromotionDAO promoDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Promotion> promotions = promoDAO.findAll();
		request.setAttribute("promotions", promotions);
		request.getRequestDispatcher("/WEB-INF/add_member.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Member member = parseMember(req);		
		memberDAO.save(member);
		resp.sendRedirect("dashboard");
	}
	
	private Member parseMember(HttpServletRequest req) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String promotion = req.getParameter("promotion");
		String birthdate = (String) req.getParameter("birthdate");
		return new Member(name, email, promotion,birthdate);
	}
	
	

}
