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
	<h3>관리자 페이지</h3>
	<form action="../category/add_category" method="get">
		<input type="submit" value="카테고리 추가하기"/>
	</form><br>
	<form action="../category/delete_category" method="get">
		<input type="submit" value="카테고리 삭제하기">
	</form><br>
	<form action="../category/search_category" method="get">
		<input type="submit" value="등록된 카테고리 확인하기">
	</form><br><br>
	
	<form action="../menuItem/add_menuItem" method="get" >
		<input type="submit" value="메뉴 추가하기">
	</form><br>
	<form action="../menuItem/delete_menuItem" method="get">
		<input type="submit" value="메뉴 삭제하기">
	</form><br>
	<form action="../menuItem/search_menuItem" method="get">
		<input type="submit" value="등록된 메뉴 확인하기">
	</form>
	<br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
</body>
</html>