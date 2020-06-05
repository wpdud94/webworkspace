package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchMemeberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchMemeberServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		Controller 로직 공식
		1. 폼값 받아서
		2. DAO 리턴
		3. 비지니스로직 호출
		4. 3번의 결과값을 Attribute 바인딩
		5. 네비게이션
		 */
		//1.
		String id = request.getParameter("id");
		//4.
		request.setAttribute("id", id);
		//5. 단순조회.. forward방식
		//request.getRequestDispatcher("resultView.jsp").forward(request, response);
		//5-1 include
		request.getRequestDispatcher("includeTest.jsp").include(request, response);
		PrintWriter out = response.getWriter();
		out.println("조회 완료!!!");
	}

}
