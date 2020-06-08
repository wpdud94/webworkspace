package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 시나리오
		 로그인 요청 -> 로그인 서블릿 -> 세션받기 -> vo를 세션에 바인딩 -> ProductServlet에서 기존 세션 객체 받기 -> 관심 상품 정보 세션에 넣기
		 결제서블릿도 세션 쓰기 -> 최종적으로 세션에 회원정보, 상품정보, 결제정보 다 있어야 함
		 
		 페이지 이동방식(원시적인 방식) : 요청3, 응답3... 같은 세션 쓰는지 확인
		 */
		PrintWriter out = response.getWriter();
		/*
		 1. 자동 생성된 세션 받기... Request.getSession()
		 	jsessionID값 콘솔 혹은 브라우저로 찍어보기
		 2. 폼에 입력된 값을 받고 vo객체 생성
		 3. 세션에 바인딩
		 4. 네비게이션...같은 세션 쓰는지 확인하기 위해 A태그로 to ProductServlet  
		 */
		//1. 
		// 두 가지 방법이 
		HttpSession hs = request.getSession();
		out.println("<strong>jsessionID</strong> : "+hs.getId()+"<p></p>");
		//2. 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//3.
		MemberVO pvo = new MemberVO(id, password, "아이유", "연희동");
		//4. 바인딩
		hs.setAttribute("vo", pvo);
		//5. 
		out.println("<html><body>");
		out.println("<a href=ProductServlet><strong>상품확인</strong></a>");
		out.println("</body></html>");
	}

}
