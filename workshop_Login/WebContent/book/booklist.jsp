<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
<div id="header">
	<h2>도서 목록 화면</h2>
</div>
<div id="search">
<form action="FindBookServlet">
	<select name="searchtype" id="searchtype">
		<option value="all" >전체</option>
		<option value="title">도서명</option>
		<option value="publisher">출판사</option>
		<option value="price">가격</option>
	</select>
	<input type="text" name="searchcontent" id="searchcontent">
	<input type="submit" value="검색">
</form>
</div>
<div id="table">
	<table>
		<thead>
			<tr>
				<th>도서번호</th><th>도서명</th><th>도서분류</th><th>저자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.isbn}</td>
					<td>${vo.title}</td>
					<td>${vo.catalogue}</td>
					<td>${vo.author}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="footer">
	<a href="Book.html">도서등록</a>
</div>
</body>
</html>