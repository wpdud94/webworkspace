package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<MemberVO> mlist = new ArrayList<>();

    public AllMemberServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DAO 리턴
		try {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		//2. 비지니스로직 호출
		
			mlist = dao.showAllMember();
		
		//3. 바인딩
			request.setAttribute("mlist", mlist);
		//4. 네비게이션
			RequestDispatcher rdp = request.getRequestDispatcher("allShow.jsp");
			rdp.forward(request, response);
		} catch (SQLException e) {
			System.out.println("쿼리에 문제 있음");
		}
	}

}
