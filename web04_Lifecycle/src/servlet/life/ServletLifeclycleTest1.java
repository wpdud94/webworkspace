package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeclycleTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;// 필드 하나 선언... servlet을 죽기 전까지, 서버 셧다운 전까지 존재
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLifeclycleTest1() {
    	System.out.println("1. constructor.... call...by container");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("2. init.... call...by container");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("4. destroy.... call...by container");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		//System.out.println("doGet......."); //서버 콘솔 창에 표시
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service.... call...by container");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//웹 브라우저로 출력
		out.println("<html><body bocolor ='yellow'>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>Count :: </b>"+ ++count);
		out.println("</body></html>");
		
		out.close();	
	}

}
