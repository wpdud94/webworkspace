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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<MemberVO> mlist = new ArrayList<MemberVO>();
       
    public RegisterServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		//2. VO 객체 생성
		MemberVO member = new MemberVO(id, password, name, addr);
		
		//3. DAO 리턴
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//4. 비지니스로직 호출
		try {
			dao.registerMember(member);
			//mlist=dao.showAllMember();
			response.sendRedirect("AllMember?name="+name);
		
		//5. 바인딩
		//request.setAttribute("mlist", mlist);
		
		//6. 네비게이션
		//RequestDispatcher rdp = request.getRequestDispatcher("allShow.jsp");
		//rdp.forward(request, response);
		} catch (SQLException e) {
			System.out.println("쿼리에 오류가 있습니다.");
		}
	}

}
