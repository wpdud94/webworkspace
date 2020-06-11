package pattern.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Command 값
		String command = request.getParameter("command");
		String path = "error.jsp";
		//2. Factory와 소통
		ControllerFactory cf = ControllerFactory.getInstance();
		Controller controller = cf.createController(command);
		
		//3. Component와 소통
		try {
			path = controller.execute(request, response);
		} catch (Exception e) {
			System.out.println("Controller 에러");
		}
		//4. 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}

}
