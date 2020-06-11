package patten.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = "/DispatchsServlet",loadOnStartup = 1)
public class DispatchsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatchsServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. command 받ㄱ
		String command = request.getParameter("command");
		String path = "error.jsp";
		//2. factory
		ControllerFactory cf = new ControllerFactory();
		Controller controller = cf.createController(command);
		//3. interface
		try {
			path = controller.execute(request, response);
		}catch(Exception e) {
			System.out.println("컨트롤러 오류");
		}
		
		//4. navi
		request.getRequestDispatcher(path).forward(request, response);
	}

}
