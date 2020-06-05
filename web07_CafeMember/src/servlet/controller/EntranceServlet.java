package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/*
	회원가입하면 정버를 바탕으로
	MemberVO를 생성하고
	ArrayList에 추가
	회원가입을 5명이... VO 5개 생성
	ArrayList 사이즈 = 5
	ArrayList를 ServletContextdp 바인딩
 */

public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ArrayList 자체에 동기화처리
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
	private ServletContext context = null;

    public EntranceServlet() {
    }

	public void init() throws ServletException {
		/* ServletContext 사용
		context = getServletContext();
		System.out.println("ServletContext의 주소 :: "+context);
		
		context.setAttribute("list", list);
		System.out.println("ServletContext에 카페 입장명단을 저장할 List를 미리 바인딩 합니다.");
		//미리 넣고 ServletContext에다가 직접 넣겠다~*/
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//ServletRequest 사용
		request.setAttribute("list", list);
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		System.out.println("1. 폼값 받기");
		
		MemberVO vo = new MemberVO(name, age, addr);
		System.out.println("2. 맴버 VO 생성");
		
		list.add(vo);
		System.out.println("3. MemberVO를 List에 저장");//바인딩된 리스트에 직접 저장됨
		
		out.println(name+" 님이 카페에 입장하셨습니다 <p></p>");
		System.out.println(name+" 님이 카페에 입장하셨습니다 <p></p>");
		//out.println("<a href=viewMember.jsp?name="+name+">viewMember.jsp 페이지로 이동합니다.</a>");
		//페이지 이동
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
		rdp.forward(request, response); // 이때 이동
		
		out.println("페이지 이동시켰습니다."); //이는 처리 안 됨
	}

}
