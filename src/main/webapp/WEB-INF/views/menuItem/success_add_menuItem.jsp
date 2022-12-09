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
	<h3>메뉴 추가 완료 !</h3>
	<label>메뉴 이름 : ${menuItem.menuItemName}</label>
	
	<label>메뉴 가격 : ${menuItem.price}</label>
	
	<label>메뉴 이미지 : ${menuItem.menuImage}</label>
	
	<label>메뉴 부가 설명 : ${menuItem.menuDesc}</label>
	
	
	
	<form action="../cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지로 돌아가기"/>
	</form>
	<br><br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
</body>
</html>