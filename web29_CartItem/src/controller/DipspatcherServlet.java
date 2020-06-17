package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DipspatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DipspatcherServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주소 받기
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		System.out.println(command);
		
		//HandlerMapping과 소통
		Controller controller=HandlerMapping.getInstance().createController(command);
		
		//Controller와 소통
		ModelAndView mv = new ModelAndView();
		String path = "index.jsp";
		try {
			mv= controller.handler(request, response);
			path = mv.getPath();
			System.out.println(path);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
