<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div></div>
	<h3>Eclipse Cafe</h3>
	<form action="cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지"/>
	</form><br>
	
	
	<form action="kiosk/kioskMain" method="get">
		<input type="submit" value="키오스크 화면">
	</form>
</body>
</html>