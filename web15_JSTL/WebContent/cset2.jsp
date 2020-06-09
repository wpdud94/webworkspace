<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="CODE" value="1004" scope="request"/>
<c:set var ="NAME" value="encore" scope="request"/>
<c:set var ="PRICE" value="220000" scope="request"/>
<jsp:forward page="cset2_view.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cset2</title>
</head>
<body>
상품코드 : ${CODE }
</body>
</html>