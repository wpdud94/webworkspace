package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context=null;
       
    public ViewServlet() {
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
		/*
		1. Attribute에 바인딩된 데이터 받아와서
		2. 웹브라우저로 출력하는 로직 작성
		 */
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		//1.
		context = getServletContext();
		MemberVO vo = (MemberVO) context.getAttribute("vo");
		
		//2. 
		PrintWriter out = response.getWriter();
		out.println("<h2>회원가입이 완료됐습니다.</h2> <br>");
		out.println("이 름 : "+ vo.getName()+"<br>");
		out.println("나 이 : "+ vo.getAge()+"<br>");
		out.println("주 소 : "+ vo.getAddr()+"<br>");
		
		out.close();
	}

}
