<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 필기내용 0609_JSTL 참고 -->
<!-- 변수선언 -->
<c:set var ="num1" value ="7"/>
<c:set var ="num2" value ="9"/>

<!-- 변수 연산 -->
<c:set var ="multiple" value ="${num1*num2 }"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JST1</title>
</head>
<body>
<b>${num1 }과 ${num2 }의 곱은 ${multiple }입니다.</b>
</body>
</html>