/*
	서블릿 필드값 count값을 영구적으로 보관할 수 있는 방법은 지금으로서는 없다...
	왜냐하면 서버가 stop되는 순간 destroy() callback 함수가 자동으로 호출됨
	서블릿 인스턴스가 메모리에서 unbound 시켜버리기 때문
	
	서바가 내려가더라도 서비스를 수행한 후 필드에 저장시킨 값을 영구적으로 보관하려면...
	1) DB에 보관
	2) file에 보관
	DB연결하기 벅차기에 file에 연결
	
	이때 서블릿 라이프사이클 메소드가 중요하게 사용됨
	1) 해당 필드값을 file로 출력 -- 
	2) file에 저장된 값을 불러와야 함
	
	init() -- 2)
	
	destroy() -- 1)
 */
package servlet.life;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLifeclycleTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path ="c:\\filestore\\life\\count.txt";
       
    public ServletLifeclycleTest3() {
    	System.out.println("1. constructor.... call...by container");
    }

	public void init() throws ServletException {
		System.out.println("2. init.... call...by container");
		
		//서버가 다시 시작될 때 init()에서 파일에 저장된 내용을 읽어서... 필드에 다시 할당
		//0 아닌 해당 숫자 이후부터 카운팅 진행
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
			
			System.out.println("count.txt 파일의 내용을 읽어들임... count ::" +count);
			br.close();
		}catch(IOException e) {
			System.out.println("파일을 읽는 데 실패했습니다.");
		}
	}

	public void destroy() {
		System.out.println("4. destroy.... call...by container");
		
		//필드에 저장된 값을 파일로 뿌리고 서버가 내려짐
		java.io.File file  = new java.io.File(path);
		//출력용 파일이 출력스트림에서 자동적으로 생성되려면... 디렉토리가 기존재해야 한다.
		// 파일 생선 전 경로까지 가져옴. 그거를 디렉토리 만들기. 컴퓨터는 경로와 파일을 구분 못 함. 다 Directory로 이해.
		file.getParentFile().mkdirs(); // 파일을 제외한 디렉토리를 만든다.
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));//file 옆 인자값은 append?, 뒤 인자는 autoflushing
			pw.println(count);
			pw.close();
			System.out.println(path+" count 값 :: "+count+" 파일에 영구적 저장");
		}catch(IOException e) {
			System.out.println("스트림 생성 실패");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		//System.out.println("doGet......."); //서버 콘솔 창에 표시
	}

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
