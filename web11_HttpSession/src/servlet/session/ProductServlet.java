package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		1. 기존 세션 받기
		2. 세션에 바인딩된 있다면 그 값을 찾아온다
		3. 2번에서 받아온 정보를 여기서 출력... 세션의 jsessionID값도 출력... 동일한지 확인
		4. 상품정보를 하나 세션에 다시 바인딩
		5. 네비게이션... A태그... href=CartServlet
		 */
		PrintWriter out = response.getWriter();
		//1.
		HttpSession hs = request.getSession();
		//2. 
		if(hs.getAttribute("vo")!=null) {//로그인이 성공했다면
			MemberVO mvo = (MemberVO) hs.getAttribute("vo");
			out.println("<html><body>");
			out.println("jsessionID : "+ hs.getId()+"<p></p>");
			out.println("I D : "+ mvo.getId()+"<p></p>");
			out.println("이 름 : "+ mvo.getName()+"<p></p>");
			out.println("주 소 : "+ mvo.getAddr()+"<p></p>");
			out.println("</body></html>");
			//3.
			hs.setAttribute("pvo", "아이폰");
			out.println("<a href=CarServlet>CartServlet으로 이동</a>");
		}else {
			out.println("<html><body>");
			out.println("session에 바인딩된 객체가 없습니다.... 로그인 실패");
			out.println("<a href=login.html>로그인 페이지로 돌아가기</a>");
			out.println("</body></html>");
		}
		
		
	}

}
