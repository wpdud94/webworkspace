<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    EL::
    Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
    변수명이 아니라 객체를 바인딩한 이름이 사용된다.
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Attribute에 바인딩된 값을 받아오겠습니다</h2>
<b>1~50까지의 합산 결과값을 받아와야 함 1) :: </b>
<%= request.getAttribute("RESULT") %> 
<%= session.getAttribute("RESULT") %> 
<!-- request와 session 중 어느 게 나올까? 맨 처음-->
<hr><p>
<b>1~50까지의 합산 결과값을 받아와야 함 2) EL:: </b>
${requestScope.RESULT}<br>
${sessionScope.RESULT}<br>
${RESULT} <!-- 맨처음 -->
</body>
</html>