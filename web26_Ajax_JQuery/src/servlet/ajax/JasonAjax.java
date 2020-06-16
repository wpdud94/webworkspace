package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domian.Food;
/*
 Json형식의 비동기 코드를 작성하려면... JSON lib이 있어야 한다
 */
@WebServlet("/JasonAjax")
public class JasonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JasonAjax() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//JSONObject 객체 생성... jason.jar 필요
		JSONObject json = new JSONObject();
		
		/*json.put("name", "Jason");
		json.put("age", 26);
		json.put("addr", "Texas");
		
		out.print(json);*/
		
		Food food = new Food();
		food.setMaker("banana");
		food.setPrice(3000);
		json.put("food", food);
		out.print(json);
	}

}
