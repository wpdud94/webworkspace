package patten.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		String id = request.getParameter("id");
		MemberDAOImpl dao =  MemberDAOImpl.getInstance();
		MemberVO vo = dao.findByIdMember(id);
		request.setAttribute("vo", vo);
		if(vo!=null) {
			path="find_ok.jsp";
		}
		return path;
	}

}
