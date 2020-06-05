package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest1 extends GenericServlet{
	/*
		클라이언트가 요청하면 호출되는 메소드
		요청 정보를 ServletRequest에 저장 --- Command
		요청을 수행하 후 응답 정보를 ServletResponse 저장 --- Command의 Result
	 */

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 요청을 받았다 치고 바로 응답만 해보겠다... to 클라이언트의 브라우저
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor='yellow'>"); //브라우저로 응답...출력...html로
		out.println("<h2>Hello ~~~ GenericServlet!!!</h2>");
		out.println("</body></html>");
		
		out.close(); // 일종의 stream
	}
	
}
//http://127.0.0.1:8888/web01_GenericServlet/GenericServletTest1 이 주소로
/*
서블릿 작성 -> 서버 가동 -> context 단위로 서버에 배포(Tomcat>Webapps>) -> 서버 상 GenericServletTest1을 출력 : 이 과정을 이클립스가 다 함|
*/
/*
404나오는 경우 : 파일이 없거나, 경로가 잘못됐거나
*/