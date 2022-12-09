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
	
		
	 <p>삭제 완료</p>

	<br><br><br><br>
	<form action="show_cart" method="get">
		<input type="submit" value="장바구니로 돌아가기">
	</form>
	<br><br>
	<form action="kioskMain" method="get">
		<input type="submit" value="주문하기 메인화면으로 ">
	</form>
	
	
	<br><br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
	
	
</body>
</html>