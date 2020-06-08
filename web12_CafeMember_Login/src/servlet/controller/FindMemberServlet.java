package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberVO member;
       
    public FindMemberServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//강사님
		//1. 폼값 받기
		String id = request.getParameter("id");
		//2. DAO & 비지니스
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			member = dao.findByIdMember(id);
		} catch (SQLException e) {
			System.out.println("쿼리 문제");
		}
		//3. 바인딩
		request.setAttribute("member", member);
		//4. 네비게이션
		String isId =member.getId();
		System.out.println(isId==null);
		if(isId==null){
			RequestDispatcher rdp = request.getRequestDispatcher("find_fail.jsp");
			rdp.forward(request, response);
		}else {
			RequestDispatcher rdp = request.getRequestDispatcher("find_Ok.jsp");
			rdp.forward(request, response);
		}
	}

}
