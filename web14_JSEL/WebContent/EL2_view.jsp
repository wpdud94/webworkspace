<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. jsp 기본 받아오기</b> <p>
<%= request.getParameter("userId") %><p>

<b>2. EL로 받아오기</b><p>
${param.userId}<br>
<hr>
<b>1. 체크박스: 기본값으로 받아오기</b>
<%
	String [] menus = request.getParameterValues("menu");
	for(String menu : menus){
%>
	<%= menu %>
<%	
	}
%>
<p>
<b>2. EL로 받기</b> <!-- 선택 안 하면 안 보임 -->
${paramValues.menu[0] }
${paramValues.menu[1] }
${paramValues.menu[2] }
${paramValues.menu[3] }
</body>
</html>