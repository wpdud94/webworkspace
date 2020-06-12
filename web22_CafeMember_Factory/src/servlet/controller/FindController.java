package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;
import sun.net.httpserver.HttpServerImpl;

public class FindController implements Controller{

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		String id=request.getParameter("id");
		MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
		if(vo!=null) {
		request.setAttribute("vo",vo);
		path="find_ok.jsp";
		}
		System.out.println(vo);
		return new ModelAndView(path);
		}
	
}
