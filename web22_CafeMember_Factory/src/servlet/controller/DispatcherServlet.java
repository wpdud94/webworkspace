package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")//확장자가 있고 파일명이 *인 경우 /붙이면 에러남
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hidden 값으로 들어온 요청을 받지 않고 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI=request.getRequestURI();
		System.out.println("RequestURI :: "+requestURI);//web22_CafeMember_Factory/find.do를 리턴
		String contextPath=request.getContextPath();
		System.out.println("contextPath :: "+contextPath);
		
		//find.do만 추출...substring()사용
		String command =requestURI.substring(contextPath.length()+1);
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		String path = "index.jsp";
		ModelAndView mv=new ModelAndView();
		boolean isRedirect = false;
		try {
			mv= controller.handler(request,response);
			path= mv.getPath();
		}
		catch (Exception e) {System.out.println(e);}
		if(!isRedirect) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else response.sendRedirect(path);
		}
	}
}
