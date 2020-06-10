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

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼 값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		String path = "update_result.jsp";
		//2. pvo 생성
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		try {
			//3. DAO&Biz
			MemberDAOImpl dao = MemberDAOImpl.getInstance();
			dao.updateMember(pvo);
			//4. 수정된 정보를 반드시 세션에 바인딩
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo);
			}
			//5. 네비게이션 to update_result.jsp
			request.getRequestDispatcher(path).forward(request, response);
		} catch (SQLException e) {
			
		}
		
	}

}
