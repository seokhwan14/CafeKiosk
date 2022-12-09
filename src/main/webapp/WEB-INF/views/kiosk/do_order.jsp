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
	<h3>♥ ${menuItem.menuItemName} ♥</h3>
	
	<table border="1">
		<tr>
			<th> 메뉴 이름 </th>
			<th> 메뉴 가격 </th>
			<th> 메뉴 이미지 </th>
			<th> 메뉴 부가 설명 </th>
		</tr>
		<tr>
			<td>${menuItem.menuItemName}</td>
			<td>${menuItem.price}</td>
			<td>${menuItem.menuImage}</td>
			<td>${menuItem.menuDesc}</td>
		</tr>
	</table>
	<br><br>
	
	<form action="do_order" method="post">
		<p>${menuItem.menuItemName}</p>
		<input type="hidden" value="${menuItem.menuItemName}" name="menuItemName"/>
		
		<p>음료 갯수</p>
		<input type="text" name="countMenu" required/>
		<br>
		
		
		<p>음료 온도</p>
		<select name="tempType" required>
			<option value="cold">시원하게</option>
			<option value="hot">따뜻하게</option>
		</select>
		<br>
		
		
		<p>사이즈</p>
		<select name="size" required>
			<option value="small">Small</option>
			<option value="medium">Medium</option>
			<option value="large">Large</option>
		</select>
	
		<input type="submit" value="카트에 추가하기">
	</form>
	
	
	
	
	<br><br><br><br>
	
	
	
	<form action="show_cart" method="get">
		<input type="submit" value="카트 확인">
	</form>
	
	
	<br><br>
	
	<form action="kioskMain" method="post">
		<input type="submit" value="돌아가기">
	</form>
	
	<br><br>
	
	<form action="kioskMain" method="get">
		<input type="submit" value="키오스크 메인화면으로 ">
	</form>
	
	
	<br><br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
	
	
</body>
</html>