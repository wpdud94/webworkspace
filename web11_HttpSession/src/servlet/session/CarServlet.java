package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 기존 세션을 받는다
		 * 2. jsessionID, vo, pvo 정보 출력
		 * 3. 현재 세션에 바인딩된 정보가 있다면 세션 죽인다.... 로그아웃
		 * 	  현재 세션에 바인딩된 정보가 없다면 다시 로그인...
		 */
		PrintWriter out = response.getWriter();
		//1.
		HttpSession hs = request.getSession();
		//2.
		MemberVO vo = (MemberVO) hs.getAttribute("vo");
		out.println("<html><body>");
		out.println("jsessionID : "+hs.getId()+"<p></p>");
		out.println("회원 정보 : "+ vo.toString()+"<p></p>");
		out.println("구매 상품 : "+ hs.getAttribute("pvo")+"<p></p>");
		//out.println("</body>");
		if(hs.getAttribute("vo")!=null&&hs.getAttribute("pvo")!=null) {
				hs.invalidate();
				out.println("<script>");
				out.println("alert('로그아웃되셨습니다.')");
				out.println("location.href='login.html'");
				out.println("</script>");
				//out.println("<a href=login.html>로그인 페이지로 돌아가기</a>");
				out.println("</body></html>");
		}else {
			response.sendRedirect("login.html");
		}
	}

}
