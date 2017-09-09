package fr.epf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.MemberDAO;


@WebServlet("/delete_member")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private MemberDAO memberDAO;
	
    public DeleteMemberServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idMember= Long.valueOf(request.getParameter("idMember"));
		memberDAO.deleteOne(idMember);
		 response.sendRedirect("dashboard");
	}


}
