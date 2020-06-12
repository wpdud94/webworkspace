<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 데사_0610_<회원수정 알고리즘> 참고 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Member</title>
</head>
<body>
<h2>Update Member Form</h2>
<form action="update.do" method="post">
	ID : <input type ="text" name="id" value="${sessionScope.vo.id}" readonly="readonly"> <!-- sessiong.getAttribute("vo").getId(); --> <br>
	PASSWORD : <input type ="password" name="password" value="${sessionScope.vo.password}"><br>
	NAME : <input type ="text" name="name" value="${vo.name}"><br>
	ADDRESS : <input type="text" name="address" value="${vo.address}"><br>
	<input type="submit" value="정보수정">
</form>
<br>
<h3><a href="index.jsp">홈으로</a></h3>
</body>
</html>