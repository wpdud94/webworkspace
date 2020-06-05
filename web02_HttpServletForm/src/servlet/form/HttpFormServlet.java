package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* 클라이언트의 요청이 들어올 때 WAS가 
	 * 
	 * 1) request, response 객체 생성
	 * 2) 함수 호출 : service(request,response);
	 * 3) 스레드 생성됨 
	 */
  	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		/*
  		 * 한글처리... 양방향
  		 * 폼에 입력된 모든 데이터를 받아서 웹브라우저로 출력하는 로직 작성
  		 */
  			
  		//1. 한글로 변환하기
  		 request.setCharacterEncoding("utf-8"); 
  		/* 위의 코드는 주석처리해도 한글로 잘 나온다... request에 담겨서 가는게 아니기 때문에.
  		 * get방식으로 날아감. 주소창에 폼에 입력한 값을 ?&..로 묶여서 날아감 >> 이 경우 장문의 글을 썼을 때, 개인정보를 담은 글이 그대로 노출됨
  		 * post로 하면 request에 담아서 날아가는 것.
  		 * form 태그에서 method를 post로 지정 안하면 get 방식으로 날아감.
  		 */
  		//1. PrintWriter 받기 전에 한글처리 해야함.
  		
  		response.setContentType("text/html;charset=utf-8");
  		
  		
  		//2. 폼에 있는 값 받아오기
  		String id =request.getParameter("userID");
  		String pass =request.getParameter("userPass");
  		String[] menus =request.getParameterValues("menu");
  		
  		//3.값 주입
  		PrintWriter out = response.getWriter();
  		String html="";
  		html+="<html><body><h2>정보를 출력합니다...</h2><li>당신의 아이디 : "+id+"</li><li>당신의 패스워드 : "+pass+"</li></body></html>";
  		out.println(html);
  		out.println("<br/>당신이 좋아하는 음식들 입니다.<br/><br/>");
  		String menu="";
  		for(int i=0;i<menus.length;i++) {
  			menu+=menus[i]+"";
  		}
  		out.println(menu);
  		out.println("</body></html>");
  		out.close();		
  	}

}
