package servlet.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.DispatchType;

import servlet.Model.UserDAOImpl;
import servlet.Model.UserVO;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값 받기
		String getId = request.getParameter("userid");
		String getPass = request.getParameter("password");
		
		//2. DAO, Biz
		UserDAOImpl dao = UserDAOImpl.getInstance();
		try {
			//3. vo객체생성
			UserVO uvo = dao.login(getId, getPass);
			if(uvo!=null) {
				//3. session 바인딩
				HttpSession session = request.getSession();
				session.setAttribute("uvo", uvo);
				//4. navigation
				response.sendRedirect("loginSuccess.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			System.out.println("SQL코드 오류");
		}
		
	}

}
