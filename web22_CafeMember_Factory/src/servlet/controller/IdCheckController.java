package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 폼값
		String id = request.getParameter("id");
		String path = "idcheck.jsp";
		//System.out.println(id);
		try {
			//2. DAO&BIZ & 바인딩
			boolean flag = MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("flag", flag);
		}catch(SQLException e) {
			System.out.println("코드 에러");
		}
		return new ModelAndView(path);
	}

}
