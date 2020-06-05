/*
 * 한 화면에서 get,post 2개 방식으로 동시에 요청할 수 있음.
 * 그런데 한 Servlet에서는 1번에 1개 방식밖에 못써...
 * 이를 해결하기 위해서  process 메소드를 하나 만들고 
 * get 또는 post어느것을 클릭하든 doProcess를 호출하고 거기서 해결하도록 함. 
 */
package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintHeaderServlet
 */
public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);	
		}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기에 작성
		//1. 한글처리
		request.setCharacterEncoding("utf-8");
  		response.setContentType("text/html;charset=utf-8");
  		
  		PrintWriter out=response.getWriter();
  		String html="<html><body bgcolor=lightyellow><h2>=======Header Infromation Printed=====</h2>";
  		out.println(html);
  		
  		//2.header 정보뽑기
  		Enumeration<String> en = request.getHeaderNames();
  		while(en.hasMoreElements()) {
  			String key=en.nextElement();
  			String value=request.getHeader(key);
  			out.println(key+":"+value+"<br/>");
  		}
  		out.println("<hr>");//
  		
  		String id=request.getParameter("id");
  		String id2=request.getParameter("i");
  		String pass2=request.getParameter("p");
  		out.println(id+","+id2+","+pass2);
  		out.println("</body></html>");
	}

}
