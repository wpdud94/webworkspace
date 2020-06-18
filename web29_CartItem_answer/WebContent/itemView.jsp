<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><b>${item.name}</b></h1>
<table align="center" width="600">
	<tr>
		<td align="right">조회수 : ${item.count} &nbsp;&nbsp;&nbsp;&nbsp;
			<button>장바구니 담기</button> &nbsp;&nbsp; <button>장바구니 확인</button>
		</td>
	</tr>
</table>
<table align="center" width="600">
	<tr>
		<td rowspan="3"><img src="${item.url}"></td>
		<td>종 류 : ${item.name}</td>
	</tr>
	<tr>
		<td>가 격 : ${item.price}</td>
	</tr>
	<tr>
		<td>설 명 : ${item.description}</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><a href="itemList.do">상품 목록 보기</a></td>
	</tr>
</table>
</body>
</html>






