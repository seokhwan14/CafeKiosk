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
	<h3>메뉴 확인을 하실 카테고리를 선택해주세요</h3>
	<form:form method="post" modelAttribute="menuItem">
		
		<form:select path="menuCategoryName" name="menuCategoryName">
			<label>확인하실 메뉴의 카테고리를 선택해 주세요.</label><br>
			<option value="unknown">---카테고리선택---</option>
			<form:options itemValue="categoryHost" itemLabel="categoryHost" items="${CategoryProviderList}"/>
		</form:select><br>
		<input type="submit" value="메뉴 확인하기">	<br><br>	
	</form:form>
	
	<form action="../cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지로 돌아가기"/>
	</form>
	<br><br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
</body>
</html>