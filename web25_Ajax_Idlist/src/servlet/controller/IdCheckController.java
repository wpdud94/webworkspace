package servlet.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		//1. 폼값
		String id = request.getParameter("id");
		//System.out.println(id);
		try {
			//2. DAO&BIZ & 바인딩
			boolean flag = MemberDAOImpl.getInstance().idExist(id);
			System.out.println(id);
			System.out.println(flag);
			out.print(flag);
		}catch(SQLException e) {
			System.out.println("코드 에러");
		}
		return null;
	}

}
