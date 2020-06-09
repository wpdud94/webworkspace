package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
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
		1. 폼값 받는다
		2. dao리턴 받고 biz 호출
		3. 세션을 받아온다
		4. 결과값 세션 바인딩... jsessionID값 콘솔에 출력
		5. 페이지 이동...login_result.jsp
		 */
		//1.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//2.
		try {
			MemberDAOImpl dao = MemberDAOImpl.getInstance();
			MemberVO vo = (MemberVO) dao.login(id, password);
			
			//3.
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			
			//4.
			response.sendRedirect("login_result.jsp");
		}catch(SQLException e) {
			System.out.println("코딩 문제");
		}
	}

}
