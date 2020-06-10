package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet(urlPatterns= "/front.do", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 어디에서 들어온 요청인지?
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		if(command.equals("register")) {
			path = register(request,response);
		}else if(command.equals("find")) {
			path = find(request,response);
		}else if(command.equals("idcheck")) {
			path = idcheck(request,response);
		}else if(command.equals("login")) {
			path = login(request, response);
		}else if(command.equals("logout")) {
			path = logout(request, response);
		}else if(command.equals("allmember")) {
			path= allmember(request, response);
		}else if(command.equals("update")) {
			path= update(request, response);
		}
		
		request.getRequestDispatcher(path).forward(request, response); //공통메소드 빼내기
	}//doProcess
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "register_ok.jsp";
		
		MemberVO pvo  = new MemberVO(id, password, name, address);
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			
		}catch(SQLException e) {
			
		}
		return path;
	}
	
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);
				path = "find_ok.jsp";
			}			
		}catch(SQLException e) {
			
		}
		return path;
	}
	
	protected String idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값
		String id = request.getParameter("id");
		String path = "idcheck.jsp";
		//System.out.println(id);
		try {
			//2. DAO&BIZ
			MemberDAOImpl dao = MemberDAOImpl.getInstance();
			//3. 바인딩
			boolean flag = dao.idExist(id);
			//System.out.println(flag);
			request.setAttribute("flag", flag);
			
		}catch(SQLException e) {
			System.out.println("코드 에러");
		}
		return path;
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path ="login_result.jsp";
		
		try {
			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			
			if(rvo !=null ) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());				
				}
		} catch (SQLException e) {			
		}
		return path;
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃 로직... Invaildate()
		String path = "logout.jsp";
		//세션 받기
		HttpSession session = request.getSession();
		//로직
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
		}
		return path;
	}
	
	protected String allmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "allView.jsp";
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
		}catch(SQLException e) {
			
		}
		return path;
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			MemberDAOImpl dao = MemberDAOImpl.getInstance();
			dao.updateMember(pvo);
			//4. 수정된 정보를 반드시 세션에 바인딩
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo);
			}
		} catch (SQLException e) {
			
		}
		return path;
	}

}
