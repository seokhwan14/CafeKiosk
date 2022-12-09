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
	<h3> 최종 결제 내역 </h3>
	<p>구매하시는 물건 목록</p>
	<c:forEach var="cartItem" items="${cartItemlist}">
		<p> ${cartItem.menuItemName} </p>	
	</c:forEach>
	<br><br>
	
	<table>
		<tr>
			<th>price : </th>
			<th>count : </th>
		</tr>
		<tr>
			
		</tr>
	</table>
	
	<br><br>
	
	<c:forEach var="menuItem" items="${menuItemlist}">
		<p>${menuItem.price}</p>
	</c:forEach>
	<c:forEach var="cartItem" items="${cartItemlist}">
		<p>${cartItem.countMenu}</p>
	</c:forEach>
	
	  
	<c:forEach var="cartItem" items="${menuItemlist}" varStatus="statusNm">
		<div>price : ${menuItem.price}</div>
    	<c:forEach var="cartItem" items="${Data[statusNm.index]}" varStatus="status">
    		<div>count : ${cartItem.menuCount}</div>
    	</c:forEach>
	</c:forEach>
	
	
	
	
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
			<option value="cold">시~~~~원하게</option>
			<option value="hot">뜨뜻~~~허게</option>
		</select>
		<br>
		
		
		<p>사이즈</p>
		<select name="size" required>
			<option value="small">Small</option>
			<option value="medium">Medium</option>
			<option value="large">Large</option>
		</select>
	
		<input type="submit" value="추가하기">
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