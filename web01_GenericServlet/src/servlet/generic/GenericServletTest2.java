package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class GenericServletTest2
 */
public class GenericServletTest2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// Brower로 응답할 때 PrintWirter 사용
		PrintWriter out =response.getWriter(); 
		out.println("<html><body><h2>");
		out.println("Hello GenericTest2");
		out.println("</h2></body></hmtl>");
	}

}
/*
[Servlet Instance Mapping 정보] -- WAS가 인지할 내용
FQCN : servlet.generic.GenericServletTest2
Server 내부이름 매핑 : GenericServletTest2 (현업에서는 기므로 짧게)
클라이언트 url 매핑 : GS2
*/