package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.Model.BookDAOImpl;
import servlet.Model.BookVO;

public class AllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AllBookServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. dao, biz
		String path = "./book/booklist.jsp";
		try {
			BookDAOImpl bookdao = BookDAOImpl.getInstance();
			ArrayList<BookVO> list = bookdao.AllBooks();
			
			//2. 바인딩
			request.setAttribute("list", list);
			//3. 네비게이션
			request.getRequestDispatcher(path).forward(request, response);
		}catch(SQLException e) {
			System.out.println("코드 오류");
		}
		
	}

}
