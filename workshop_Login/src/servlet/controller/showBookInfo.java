package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.Model.BookDAOImpl;
import servlet.Model.BookVO;

public class showBookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public showBookInfo() {
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
		String isbn = request.getParameter("isbn");
		String path = "./book/bookInfoResult.jsp";
		
		try {
			BookVO result = BookDAOImpl.getInstance().findBook(isbn);
			//System.out.println(pvo);
			request.setAttribute("result", result);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (SQLException e) {
			System.out.println("쿼리 문제");
		}
	}

}
