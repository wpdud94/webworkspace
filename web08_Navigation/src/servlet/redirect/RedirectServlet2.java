package servlet.redirect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectServlet2() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		checkbox를 선택하지 않으면 error 페이지로 이동
		그렇지 않은 경우 forwarding으로 내용 전달함
		 */
		String choose =request.getParameter("choose");
		if(choose==null) {
			request.getRequestDispatcher("error/error.html").forward(request, response);
		}else {
			// 바인딩 안 해도 됨... request 그대로 쓰니까
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		}
	}

}
