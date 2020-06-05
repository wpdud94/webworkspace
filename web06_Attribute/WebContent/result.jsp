<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    /* 로직은 여기다가 쓴다 */
   	MemberVO vo = (MemberVO) application.getAttribute("vo");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 정보를 출력합니다.</h2>

<li> 당신의 이름은 <%= vo.getName() %></li>
<li> 당신의 나이는 <%= vo.getAge() %></li>
<li> 당신의 주소는 <%= vo.getAddr() %></li>

</body>
</html>