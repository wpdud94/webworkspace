<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ItemList</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	body{
		width:1000px;
		margin:0 auto;
	}
		#totalList>h1{
			margin-top: 30px;
		}
	
		#totalList>table{
			margin: 30px 0 30px 115px;
		}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div id="totalList">
	<h1 align="center">Fruit Total List 1.</h1>
	<table>
		<tr>
			<c:forEach items="${list}" var="item">
			<td>
				<a href ="itemInfo.do?itemNumber=${item.itemNumber}">
				<img src="${item.url}" width="150" height="150" style="border: 2px solid blue">
				</a><br/>
				상품명 : ${item.name}<br/>
				가 격 : ${item.price}원
			</td>
			</c:forEach>
		</tr>
	</table>
	<hr>
	<%-- <table>
		<tr>
			<c:forEach items="${list}" var="item">
			<td><img src="${item.url}" width="150" height="150" style="border: 2px solid blue"></td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${list}" var="item">
			<td>상품명 : ${item.name}</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${list}" var="item">
			<td>가 격 : ${item.price}</td>
			</c:forEach>
		</tr>
	</table> --%>
</div>
</body>
</html>