<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
ArrayList<MemberVO> mlist = (ArrayList<MemberVO>) request.getAttribute("mlist");
String name =request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allShow</title>
</head>
<body>
<%if(name!=null) {%>
<h2> 
<%=request.getParameter("name")%> 님, 회원가입이 완료됐습니다.
</h2>
<%} %>
<p></p>
<h2>전체 회원 명단</h2>
<table border="">
	<thead>
		<tr>
			<th>번 호</th><th>I D</th><th>이 름</th><th>주 소</th>
		</tr>
	</thead>
	<tbody>
	<%for(int i=0;i<mlist.size();i++){%>
		</tr>
		<td><%=i+1 %></td>
		<td><%=mlist.get(i).getId() %></td>
		<td><%=mlist.get(i).getName() %></td>
		<td><%=mlist.get(i).getAddr() %></td>
		</tr>
	<%} %>
	</tbody>
</table>
<p></p>
<a href="index.html">메인 페이지로 돌아가기</a>
</body>
</html>