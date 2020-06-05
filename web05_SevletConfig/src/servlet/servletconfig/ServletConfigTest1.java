package servlet.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String addr;

       
    public ServletConfigTest1() {
        System.out.println("생성자 호출....");
    }

	public void init() throws ServletException {
		System.out.println("init() 호출....");
		name=getInitParameter("name");
		addr=getInitParameter("addr");
		
		System.out.println(name+", "+addr);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>A Servlet Instance Initialization... Using ServletConfig</h2><p></p>");
		out.println("당신의 이름: "+name+"<br/>");
		out.println("당신의 주소: "+addr+"<br/>");
		
		out.close();
	}

}
