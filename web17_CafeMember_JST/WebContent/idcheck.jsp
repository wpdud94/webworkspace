<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Check</title>
<script type="text/javascript">
	function closeWindow(result) {
		//확인버튼 누르면 이곳으로 온다... 여기서 회원가입폼을 제어해야 한다
		var off= window.opener.document.registerForm;
		if(result=='true'){//아이디 사용 불가
			off.id.value="";
			off.id.focus();
		}else{//아이디 사용 가능
			off.password.focus();
			off.id.setAttribute('readonly','readonly');
			off.id.setAttribute('style','background-color:#e3e3e3');
			//off.id.readOnly=true;
		}
		self.close();
	}
</script>
<style type="text/css">
	body {
		background-color: orange;
	}
</style>
</head>
<body>
	<c:set var="message" value="해당 ID를 사용할 수 없음"/>
	<c:if test="${!flag}">
		<c:set var="message" value="해당 ID를 사용할 수 있음"/>
	</c:if>
	${param.id}, ${message}
	<input type="button" value="확인" onclick="closeWindow('${flag}')">
</body>
</html>