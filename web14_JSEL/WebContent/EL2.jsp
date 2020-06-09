<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Form값을 EL로 받아오기</h2>
<form action="EL2_view.jsp" method="post">
ID <input type="text" name="userId">
<input type="checkbox" name="menu" value="spagetii">spagetii
<input type="checkbox" name="menu" value="haser">haser
<input type="checkbox" name="menu" value="curry">curry
<input type="submit" value="DataSend">
</form>
</body>
</html>