package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "logout.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
		}
		return new ModelAndView(path);
	
	}

}
