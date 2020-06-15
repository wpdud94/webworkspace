package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class IdListController implements Controller {
	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "show_idlist.jsp";
		try {
			//2. DAO&BIZ & 바인딩
			ArrayList<MemberVO> memlist = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("memlist", memlist);
		}catch(SQLException e) {
			System.out.println("코드 에러");
		}
		return new ModelAndView(path);
	}

}
