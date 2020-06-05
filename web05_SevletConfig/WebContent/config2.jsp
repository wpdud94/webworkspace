<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= request.getParameter("username") %>
<b> 님은 </b>
<%= request.getParameter("cnt") %>
<b> 번째 고객님입니다.</b>
</body>
</html>