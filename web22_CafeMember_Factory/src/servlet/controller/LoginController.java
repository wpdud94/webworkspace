package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller{
	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "login_result.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			MemberVO vo = MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
		}catch(SQLException e) {System.out.println("코딩 문제");}
		return new ModelAndView(path,true);
		}
}
