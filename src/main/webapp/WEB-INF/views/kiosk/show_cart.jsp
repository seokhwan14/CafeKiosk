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
		<br><br><br>
		<!-- 카트 물품 삭제하기 -->
		
		<c:forEach var="cartItem" items="${cartItemlist}">
			<h3> ♥ ${cartItem.menuItemName} ♥</h3>
			<p> 갯수 : ${cartItem.countMenu}</p>
			<p> 음료 온도 : ${cartItem.tempType} </p>
			<p> 음료 사이즈 : 	${cartItem.size} </p>
			<form action="deleteMenu" method="post">
				<input type="hidden" value="${cartItem.menuItemName}" name="menuItemName">
				<input type="submit" value="삭제하기">
			</form>
		</c:forEach>
		<br><br>
		<form action="deleteAll" method="post">
		
			<input type="submit" value="전체 삭제하기">
		</form>
	 
	 <br><br><br>
	 
	 <form action="final_order" method="post">
	 	<input type="submit" value="주문하기">
	 </form>
	 
	 
	 
	 
	<br><br><br><br>
	<form action="ex_order">
		<input type="submit" value="이전 화면으로">
	</form>
	
	<br><br><br>
	
	<form action="kioskMain" method="get">
		<input type="submit" value="주문하기 메인화면으로 ">
	</form>
	
	
	<br><br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
	
	
</body>
</html>