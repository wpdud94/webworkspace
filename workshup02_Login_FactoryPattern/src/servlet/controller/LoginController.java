package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.Model.UserDAOImpl;
import servlet.Model.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "error.jsp";
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		UserVO pvo = UserDAOImpl.getInstance().login(userId, password);
		if(pvo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("pvo", pvo);
			path="loginSuccess.jsp";
		}

		return new ModelAndView(path);
	}

}
