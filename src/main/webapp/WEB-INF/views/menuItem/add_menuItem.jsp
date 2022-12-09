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
	<h3>메뉴 추가하기</h3>
	<form:form method="post" modelAttribute="menuItem">
		
		<form:select path="menuCategoryName">
			<label>추가하실 메뉴의 카테고리를 선택해 주세요.</label><br>
			<option value="unknown">---카테고리선택---</option>
			<form:options itemValue="categoryHost" itemLabel="categoryHost" items="${CategoryProviderList}"/>
		</form:select><br>
		
		<label>메뉴 이름 : </label><input type="text" name="menuItemName"/><br><br>
		
		<label>메뉴 가격 : </label><input type="text" name="price"/><br><br>
		
		<label>메뉴 이미지 : </label><input type="text" name="menuImage"/><br><br>
		
		<label>메뉴 부가 설명 : </label><input type="text" name="menuDesc"/><br><br>
		
		<input type="submit" value="메뉴 추가"/>
		
	</form:form>
	
	
	<form action="../cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지로 돌아가기"/>
	</form>	
</body>
</html>