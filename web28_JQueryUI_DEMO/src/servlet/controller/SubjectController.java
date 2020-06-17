package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("getSubjectController 진입");
		//비지니스로직 호출, 결과값 리턴 받았다 치고
		String result = "Algorithm  |  Big Data  |  DeepLearnung  |  Resful API  |  Vue.js";
		
		request.setAttribute("result", result);
		//System.out.println(result);
		
		return new ModelAndView("Result.jsp");//forwarding
	}

}
