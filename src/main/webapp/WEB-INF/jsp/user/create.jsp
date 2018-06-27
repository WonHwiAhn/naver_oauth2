<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Demo</title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width"/>
    <!-- <base href="/"/> -->
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	
	<form:form action="/user/createProcessing" method="post">
		<h2>회원가입</h2>
		<c:if test="${param.error != null}">
			<div>잘못된 아이디나 암호입니다.</div>
		</c:if>
		<input type="text" name="mail" placeholder="메일" required="required"/>
		<input type="password" name="auth" placeholder="암호" required="required"/>
		<input type="submit" value="회원가입"/>
	</form:form>
	



</div>
</body>
</html>