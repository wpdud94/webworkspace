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
	
		#totalList table{
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
				<img src="${item.url}" width="150" height="150" style="border: 2px solid #014A97">
				</a><br/>
				상품명 : ${item.name}<br/>
				가 격 : ${item.price}원
			</td>
			</c:forEach>
		</tr>
	</table>
	
	<!-- 오늘 본 상품 정보를 이곳에다가 출력 -->
	<c:if test="${!empty fruits}">
			<hr>
			<h2 align="center"><font color = "purple">오늘 본 상품</font></h2>
			<table align ="center" bgcolor ="lightgray">
				<tr>
					<c:forEach items="${fruits}" var="fruit">
					<td>
						<img src="${fruit}" width="100" height="100" style="border: 2px solid #014A97">
					</td>
					</c:forEach>
				</tr>
			</table>
	</c:if>
</div>
</body>
</html>