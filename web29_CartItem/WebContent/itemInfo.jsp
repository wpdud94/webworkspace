<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ItemInfo</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	body{
		width:700px;
		margin:0 auto;
	}
	#header{
		margin: 30px 0px;
	}
	#bar{
		margin-bottom:30px;
		text-align: right;
		background-color: orange;
	}
		#bar>span{
			margin-right:50px;
		}

	#footer{
		width:420px;
		text-align: center;
	}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$('#addCart').on('click', function() {
		alert(${item.name});
	});//on
</script>
</head>
<body>
<div id="header">
<h1 align="center">${item.name} 의 정보</h1>
</div>
<div id="bar">
	<span id="count">조회수 : ${item.count}</span> 
	<a href="#">장바구니 담기</a>
</div>
<div id="wrap">
	<table>
		<tr>
			<td>
				<img src="${item.url}" width="390" height="210">
			</td>
			<td style="padding-left: 20px;">
				종 류 : ${item.name} <br><br>
				가 격 : ${item.price} <br><br><br><br>
				설 명 : ${item.description}
			</td>
		</tr>
	</table>
	<br/>	
</div>
<div id="footer">
<a href="itemList.do">상품 목록 보기</a>
</div>
</body>
</html>