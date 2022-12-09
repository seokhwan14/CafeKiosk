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
	<h3>${menuItem.menuCategoryName}의 목록 </h3>
	<table border="1">
		<tr>
			<th> 메뉴 이름 </th>
			<th> 메뉴 가격 </th>
			<th> 메뉴 이미지 </th>
			<th> 메뉴 부가 설명 </th>
		</tr>
		<c:forEach var="menuItem" items="${menulist}">
		<tr>
			<td>${menuItem.menuItemName}</td>
			<td>${menuItem.price}</td>
			<td>${menuItem.menuImage}</td>
			<td>${menuItem.menuDesc}</td>
		</tr>
		</c:forEach>
	</table>
	
	<form action="search_menuItem" method="get">
		<input type="submit" value="카테고리 선택 화면으로">
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