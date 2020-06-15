package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller{

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 폼 값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "update_result.jsp";
		//2. pvo 생성
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		try {
			//3. DAO&Biz
			MemberDAOImpl.getInstance().udpateMember(pvo);
			//4. 수정된 정보를 반드시 세션에 바인딩
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo);
			}
		} catch (SQLException e) {}
		return new ModelAndView(path);
	}
	
}
