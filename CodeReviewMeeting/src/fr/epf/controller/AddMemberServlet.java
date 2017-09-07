package fr.epf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.MemberDAO;
import fr.epf.models.Member;


@WebServlet("/add_member")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MemberDAO memberDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/add_member.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Member member = parseMember(req);		
		memberDAO.save(member);
		resp.sendRedirect("index");
	}
	
	private Member parseMember(HttpServletRequest req) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String promotion = req.getParameter("promotion");
		String birthdate = (String) req.getParameter("birthdate");
		return new Member(name, email, promotion,birthdate);
	}
	
	

}
