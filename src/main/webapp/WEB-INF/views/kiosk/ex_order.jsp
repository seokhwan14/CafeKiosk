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
	
	
	
		<!-- 거의 3시간동안 헤맨 부분, form을 c:forEach 바깥에 놔두니 form이 계속 생성되는게 아니라
		하나의 form 안에서 돌기 때문에 submit이 항상 같은 결과를 보여줬다. 각각 다른 form으로 생성하게 되면
		내부의 값이 다 다르게 나옴 -->
	
		<c:forEach var="menuItem" items="${menulist}" varStatus="status">
		<form action="ex_order" method="post">
		<table border="1">
		<tr>
			<th> 메뉴 이름 </th>
			<th> 메뉴 가격 </th>
			<th> 메뉴 이미지 </th>
			<th> 메뉴 부가 설명 </th>
			<th> 장바구니 담기</th>
		</tr>
		<tr>
			<td>${menuItem.menuItemName}</td>
			<td>${menuItem.price}</td>
			<td>${menuItem.menuImage}</td>
			<td>${menuItem.menuDesc}</td>
			
			<td><input type="hidden" value="${menuItem.menuItemName}" name="menuItemName"/>
				<input type="hidden" value="${menuItem.price}" name="price"/>
				<input type="hidden" value="${menuItem.menuImage}" name="menuImage"/>
				<input type="hidden" value="${menuItem.menuDesc}" name="menuDesc"/>
				<input type="hidden" value="${status.count}" name="status">
				<input type="submit" value="해당 메뉴로 선택">
			</td>
		</tr>
		</table>
		
		<br>
		<br>
		</form>
		</c:forEach>
	
	
	<br><br><br><br>
	
	<p>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ장바구니 영역ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</p>
	<br><br>
	
	
	
	
	<form action="show_cart" method="get">
		<input type="submit" value="카트 확인">
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