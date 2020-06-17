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
		String command = request.getParameter("command");//
		
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
			else request.getRequestDispatcher(path).forward(request, response);
			//System.out.println(request.getParameter("result"));
		}
	}
}
