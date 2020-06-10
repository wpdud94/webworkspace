package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

/**
 * Servlet implementation class IdCheckServlet
 */
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값
		String id = request.getParameter("id");
		String path = "idcheck.jsp";
		//System.out.println(id);
		try {
			//2. DAO&BIZ
			MemberDAOImpl dao = MemberDAOImpl.getInstance();
			//3. 바인딩
			boolean flag = dao.idExist(id);
			//System.out.println(flag);
			request.setAttribute("flag", flag);
			//4. 네비게이션...to idcheck.jsp
			request.getRequestDispatcher(path).forward(request, response);
			
		}catch(SQLException e) {
			System.out.println("코드 에러");
		}
		
		
		
	}

}
