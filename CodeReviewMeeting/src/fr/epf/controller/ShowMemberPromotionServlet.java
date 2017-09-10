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

@WebServlet("/show_member_promotion")
public class ShowMemberPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private PromotionDAO promoDAO;





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idPromotion= Long.valueOf(request.getParameter("idPromotion"));
		Promotion promotion = promoDAO.findPromotionById(idPromotion);
		List<Member> membersOfPromotion = memberDAO.findAllOfPromotion(promotion.getName());
		request.setAttribute("membersOfPromotion", membersOfPromotion);

		request.getRequestDispatcher("/WEB-INF/show_member_promotion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
