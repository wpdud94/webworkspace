<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	
	body{
		width: 800px;
		margin: 0 auto;
		text-align: center;
	}
	#wrap{
		width: 400px;
		margin: 100px 0px 0px 120px;
		padding: 50px; 0px;
		border: 1px solid blue;
	}
</style>
</head>
<body>
<div id="wrap">
<%= request.getParameter("userid") %>
<b> 님의 정보가 없습니다.</b>
</div>
</body>
</html>