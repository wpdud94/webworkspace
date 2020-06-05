package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet2
 */
public class HttpFormServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글처리
  		request.setCharacterEncoding("utf-8");
  		response.setContentType("text/html;charset=utf-8");
  		
  		Enumeration<String> menus =request.getParameterNames();
 		
  		PrintWriter out = response.getWriter();
  		/*String html="";
  		 html+="<html><body><h2>정보를 출력합니다...</h2><li>당신의 아이디 : "+id+"</li><li>당신의 패스워드 : "+pass+"</li></body></html>";
  		out.println(html);
  		out.println("<br/>당신이 좋아하는 음식들 입니다.<br/><br/>");
  		*/
  		out.println("폼에 입력된 값들을 출력합니다.");
  		while(menus.hasMoreElements()) {
	  		String name = menus.nextElement();
	  		out.println("<li>"+name+":"+request.getParameter(name)+"</li><br/>");
	  		out.println("</body></html>");
	  		}
  		//폼의 이름을 모를 때 getParameterNames 사용.
	  	String[] str=request.getParameterValues("menu");
	  	out.println("<br> 당신이 좋아하는 음식들 입니다.<br/><br/>");
	  	String menu="";
	  	for(int i=0;i<str.length;i++) {
	  		menu+=str[i]+"";
	  	}
	  	out.println(menu);
	  	out.close();
  	}
}
