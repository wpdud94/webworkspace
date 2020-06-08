package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 * 클라이언트가 다시 요청할 때 브라이줘에 저장된 쿠키를 받아온다.
 * 받아온 쿠키 중에서 쿠키의 값과 이름을 출력해본다.
 */
public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCookieTest() {
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
		PrintWriter out = response.getWriter();
		Cookie[] ck = request.getCookies();
		for(int i=0;i<ck.length;i++) {
			out.println(ck[i].getName());
			out.println(ck[i].getValue());
		}
	}

}
