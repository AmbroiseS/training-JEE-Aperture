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

@WebServlet("/modify_member")
public class ModifyMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MemberDAO memberDAO;
	
	private Long idMember;

    public ModifyMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idMember= Long.valueOf(request.getParameter("idUser"));
		Member member= new Member();
		if (idMember instanceof Long) {
			 member= memberDAO.getMemberById(idMember);
		}
		request.setAttribute("member",member );

		request.getRequestDispatcher("/WEB-INF/modify_member.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Member member = parseMember(req);		
		memberDAO.update(member);
		resp.sendRedirect("dashboard");
	}
	
	private Member parseMember(HttpServletRequest req) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String promotion = req.getParameter("promotion");
		String birthdate = (String) req.getParameter("birthdate");
		
		Member member = new Member(name, email, promotion,birthdate);
		member.setId(idMember);

		return member;
	}
}
	
	
