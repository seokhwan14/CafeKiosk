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
	<h3>메뉴 삭제하기</h3>
	<form action="delete_menuItem" method="post">
		<label>삭제할 메뉴 이름 : </label>
		<input type="text" name="menuItemName" required/><br>
		<input type="submit" value="삭제하기">
	</form>
	
	<form action="../cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지로 돌아가기"/>
	</form>
	<br><br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
</body>
</html>