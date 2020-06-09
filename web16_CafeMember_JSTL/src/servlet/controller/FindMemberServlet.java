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
		System.out.println(id);
		//2. DAO & 비지니스
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			System.out.println(id);
			MemberVO vo = dao.findByIdMember(id);
			//3. 바인딩
			request.setAttribute("vo", vo);
			//4. 네비게이션
			if(vo==null){
				RequestDispatcher rdp = request.getRequestDispatcher("find_fail.jsp");
				rdp.forward(request, response);
			}else {
				RequestDispatcher rdp = request.getRequestDispatcher("find_Ok.jsp");
				rdp.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("쿼리 문제");
		}
		
	}

}
