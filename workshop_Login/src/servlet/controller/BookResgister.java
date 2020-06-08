package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.Model.BookDAOImpl;
import servlet.Model.BookVO;

public class BookResgister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookResgister() {
    }

	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값 받기
		String isbn ="";
		//isbn
		isbn += request.getParameter("isbn1");
		isbn += "-"+ request.getParameter("isbn2");
		isbn += "-"+
		request.getParameter("isbn3");
		//System.out.println(isbn);
		//title
		String title = request.getParameter("title");
		//System.out.println(title);
		//genre
		String catalogue = request.getParameter("catalogue");
		//System.out.println(genre);
		//country
		String nation = request.getParameter("nation");
		//System.out.println(country);
		//publishDate
		String publish_date= request.getParameter("publish_date");
		//System.out.println(publishDate);
		//publisher
		String publisher = request.getParameter("publisher");
		//System.out.println(publisher);
		//author
		String author = request.getParameter("author");
		//System.out.println(author);
		//price
		int price= Integer.parseInt(request.getParameter("price"));
		
		//System.out.println(price);

		//unit
		String currency = request.getParameter("currency");
		//System.out.println(unit);
		//summary
		String description = request.getParameter("description");
		//System.out.println(summary);
		
		//2. VO 객체 생성
		BookVO book = new BookVO(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description);
		
		//3. dao, biz
		BookDAOImpl dao = BookDAOImpl.getInstance();
		try {
			dao.registerBook(book);
		} catch (SQLException e) {
			System.out.println("코드 오류");
		}
		//3. RequestServlet에 저장
		request.setAttribute("book", book);
		
		//4. jsp로 이동
		RequestDispatcher rdp = request.getRequestDispatcher("book/bookresult.jsp");
		rdp.forward(request, response);
		
	}

}
