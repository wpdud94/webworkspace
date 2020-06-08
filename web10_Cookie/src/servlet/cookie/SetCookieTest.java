package servlet.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookieTest() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date now = new Date();
		String id = "ENCORE";
		
		//1. 쿠키 생성
		Cookie c1 = new Cookie("now", "2020-06-08");
		Cookie c2 = new Cookie("id", id+"");
		
		//2. 쿠키의 유효시간 지정... 하루로 c1에만
		c1.setMaxAge(24*60*60);
		c2.setMaxAge(0); //쿠키를 사용하지 않겠다 setMaxAge() 작동 확인
		
		//3. 쿠키를 전송
		response.addCookie(c1);
		response.addCookie(c2);
		
		//4. 페이지 이동... GetCookieTest
		response.sendRedirect("GetCookieTest");
		
		
	}

}
