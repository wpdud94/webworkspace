<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
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
		padding-top: 50px;
	}
	#header{
		margin: 10px 0px;
		padding: 22px 0px;
		height: 80px;
		
	}
		#search *{
			height: 25px;
			text-align: right;
			vertical-align: bottom;
		}
		#serach #searchcontent{
			text-align: left;
		}
		#table table{
			width: 100%;
			margin: 10px 0px 10px 0px;
		}
			#table table td, #table table th{
				border: 1px solid black;
				height: 50px;
			}
			#table table th{
				background-color: #e3e3e3;
			}
	.bookinfo{
		color : red;
		font-weight : bold;
		font-size: 0.8em;
	}
	#footer{
		margin-top: 10px;
	}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('table tr td:nth-child(2)').mouseover(function() {
		var isbn = $(this).prev().text();
		//alert(isbn);
		$.ajax({
			type:'post',
			url:'showBookInfo',
			data:"isbn="+isbn,
			
			success : function(data) {
				//alert(data);
				$('#infoView').html(data).addClass('bookinfo');
			}//callback
		});//ajax
	});//mouseover
	
	$('table tr td:nth-child(2)').mouseout(function() {
		$('#infoView').html("");
	});//mouseout
});//ready
	
</script>
</head>
<body>
<div id="header">
	<h1>도서 목록 화면</h1>
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
	<div id="infoView"></div>
</div>
<div id="footer">
	<a href="Book.html">도서등록</a>
	<a href="AllBookServlet">전체목록</a>
</div>
</body>
</html>