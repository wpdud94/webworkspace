<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cforeach</title>
</head>
<body>
<%
	String[] arr= {"삼계탕","순두부찌개","두루치기","설렁탕","곰탕"};
	request.setAttribute("arr", arr);
%>
<jsp:forward page="cForEach6_view.jsp"></jsp:forward>
</body>
</html>