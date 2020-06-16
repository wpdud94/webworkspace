package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SerialAjax")
public class SerialAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> map = new HashMap<>();
	
    public SerialAjax() {

    }
    
    @Override
    public void init() throws ServletException {
    	map.put("ajax", "James"); //key=id, value = name
    	map.put("encore", "Gosling");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		
		if(command.equals("register")) {//회원가입 폼이라면
			String name = request.getParameter("name");
			String address = request.getParameter("addr");
			out.print(address+"에 사시는 "+name+" 님, 회원가입에 성공");
		}else if(command.equals("idCheck")) {
			String id = request.getParameter("id");
			if(map.get(id)==null) 
				out.print(false);//폼으로 받은 아이다가 DB에 없다면... 사용가능
			else
				out.print(true);
		
		}
	}

}
