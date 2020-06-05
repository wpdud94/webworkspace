package servlet.servletconfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path;
	private String username;
       
    public ServletConfigTest2() {
    }

	public void init() throws ServletException {
		//1.ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다
		path = getInitParameter("path");
		try {
			//2. 파일을 읽는다
			BufferedReader br = new BufferedReader(new FileReader(path));
			//3. count값으로 필드를 초기화
			String str = br.readLine();
			count = Integer.parseInt(str);
			br.close();
		}catch(Exception e) {
			System.out.println("파일을 읽어드리는 데 실패");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다가
		//4. 폼에 입력된 값을 받아서 
		// ~~ 아무개 님은 몇 번째 입장하신 고객입니다.
		// 를 브라우저로 출력
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.println("<a href=config2.jsp?cnt="+count+"&username="+username+">click to jsp</a>");
	}

}
