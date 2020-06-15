package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("userId");
		
		// 탁구공이 건덜 때 딜레이시키는 로직... readyState값이 2~3인 경우를 볼 수 있도록 설정
		/*try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			System.out.println("이상함");
		}*/
		out.print(uid);
	}


}
