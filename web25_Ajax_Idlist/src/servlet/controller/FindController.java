package servlet.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;
import sun.net.httpserver.HttpServerImpl;

public class FindController implements Controller{

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();

		String id=request.getParameter("id");
		MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
		
		out.print(vo.getName()+" "+vo.getAddress());
		return null;
		}
	
}
