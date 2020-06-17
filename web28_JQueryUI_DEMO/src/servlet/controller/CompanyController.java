package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CompanyController 진입");
		String path = "Result.jsp";
		
		String result = "<ul><li>Tomato System</li><br>"
				+"<li>Ahn Lab Corporation</li><br>"
				+"<li>Easst Engineering</li><br>"
				+"<li>NCSoft Systems</li><br>"
				+"<li>Encore Softmax Academy</li></ul>";
		request.setAttribute("result", result);
		return new ModelAndView(path);
	}

}
