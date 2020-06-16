package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddressAjax")
public class AddressAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap map = new HashMap<>();
	
    public AddressAjax() {

    }
    /*
   	DB 연결 대신... Map을 이용해서 각 선수들의 address를 매핑
   	
   	 */
    @Override
    public void init() throws ServletException {
    	map.put("이용규", "신사동");
    	map.put("김태균", "용산동");
    	map.put("류현진", "LA");
    	map.put("푸이그", "런던");
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		out.print(map.get(name));
	}

}
