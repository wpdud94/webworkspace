package servlet.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.DispatchType;

import servlet.Model.MemberVO;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
	List<String> tlist = new ArrayList<>();
	String line;
	int size = 0;
    public MainServlet() {
    }

	public void init() throws ServletException {
		//0. path 초기화
		path = getInitParameter("path");
		//1. 경로설정
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			//2. 메모장 내용 받기
			while((line=br.readLine())!= null) {
				tlist.add(line);
			}
			System.out.println(tlist.size());
			
			br.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("BufferedReader 문제");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("readLine() 문제");
			//e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//3. 메모장 내용 필드별로 나누기... VO 생성
		for(int i=0;i<tlist.size();i++) {
			String[] farr = tlist.get(i).split(",");
			list.add(new MemberVO(farr[0], farr[1], farr[2], farr[3]));
		}
		//System.out.println(list);
		//4. 폼값 받기

		String getId = request.getParameter("userid");
		String getPass = request.getParameter("password");
		//System.out.println(getId);
		//System.out.println(getPass);
		
		//5. 비교
		boolean flag = false;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getUserid().equals(getId)&&list.get(i).getPassword().equals(getPass)) {
				flag=true;
				//System.out.println("1");
				break;
			}else {
				flag=false;
				//System.out.println("2");
			}
		}
		if(flag) {
			//out.println("<a href = loginSuccess.jsp?id="+getId+">click here</a>");
			RequestDispatcher rdp =request.getRequestDispatcher("loginSuccess.jsp");
			rdp.forward(request, response);
		}else {
			//out.println("<a href = error.jsp?id="+getId+">click here</a>");
			RequestDispatcher rdp =request.getRequestDispatcher("error.jsp");
			rdp.forward(request, response);
		}
	}

}
