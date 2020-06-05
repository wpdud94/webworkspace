package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	
       
    public RegisterServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		1. 양방향 한글처리(post니까)
		2. 폼값 받아서
		3. vo객체 생성
		4. DAO 리턴 받았다 치고
		5. 비지니스로직 호출... 했다 치고
		6. 객체 바인딩... ServletContext
		7. 페이지 이동... a태그
		 */
		
		
		
		//1.
		
		PrintWriter out = response.getWriter();
		
		//2. 폼 값 받기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); 
		String addr = request.getParameter("addr");
		
		//3. vo 객체 생성
		MemberVO vo = new MemberVO(name, age, addr);
		
		//6.
		// 필드선언, get쓰기, 객체 참조변수랑 같이
		context = getServletContext();
		context.setAttribute("vo", vo);
		
		//7. 페이지 이동
		//out.println("<a href=result.jsp> JSP결과 확인하러 가기</a>");
		out.println("<a href=ViewServlet>ViewServlet 결과 확인하러 가기</a>");
		
		out.close();
	}

}
