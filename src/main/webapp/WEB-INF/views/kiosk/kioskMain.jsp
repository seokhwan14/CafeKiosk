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
	<h3>Welcome Eclipse Cafe</h3>
	<br><br>
	
	<form:form method="post" modelAttribute="menuItem">
		<form action="kioskMain" method="post">
			<c:forEach var="category" items="${CategoryProviderList}">
				<form:input type="submit" value="${category}"
				 	path="menuCategoryName" name="menuCategoryName"/>
			</c:forEach>
		</form>
	</form:form>
	
	<br><br>
	<br><br>
	
	
	<form action="show_cart" method="get">
		<input type="submit" value="카트 확인">
	</form>
	
	<br><br><br><br>
	
	
	<form action="../cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지로 돌아가기"/>
	</form>	
</body>
</html>
		
		
		
		
		
		
		
		
		
		
	<!-- 
	<form:form method="post" modelAttribute="menuItem">
		
		<form:select path="menuCategoryName" name="menuCategoryName">
			<label>확인하실 메뉴의 카테고리를 선택해 주세요.</label><br>
			<option value="unknown">---카테고리선택---</option>
			<form:options itemValue="categoryHost" itemLabel="categoryHost" items="${CategoryProviderList}"/>
		</form:select><br>
		<input type="submit" value="메뉴 확인하기">	<br><br>	
	</form:form>
	
	<form action="kioskMain" method="post">
		<c:forEach var="category" items="${CategoryProviderList}">
			<input type="submit" value="${category}"/>
		</c:forEach>
	</form>
	 -->