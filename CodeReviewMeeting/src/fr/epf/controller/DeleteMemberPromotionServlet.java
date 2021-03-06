package fr.epf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.MemberDAO;
import fr.epf.dao.PromotionDAO;


@WebServlet("/delete_member_promotion")
public class DeleteMemberPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private PromotionDAO PromotionDAO;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idMember= Long.valueOf(request.getParameter("idMember"));
		memberDAO.deleteMemberPromotion(idMember);
		String idPromotion= Long.valueOf(request.getParameter("idPromotion")).toString();
		String theURL = "http://localhost:8080/CodeReviewMeeting/show_member_promotion?idPromotion=" + idPromotion;
		theURL = response.encodeRedirectURL(theURL);
		response.sendRedirect(theURL);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
