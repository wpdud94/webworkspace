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

public class FindBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindBookServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값 받기
		String searchType = request.getParameter("searchtype");
		String searchContent = request.getParameter("searchcontent");
		String path = "./book/booklist.jsp";
		//2. dao, biz
		try {
			BookDAOImpl bookDao = BookDAOImpl.getInstance();
			ArrayList<BookVO> list = bookDao.findBook(searchType, searchContent);
			request.setAttribute("list", list);
			request.getRequestDispatcher(path).forward(request, response);
		}catch(SQLException e) {
			System.out.println("쿼리 오류");
		}
	}

}
