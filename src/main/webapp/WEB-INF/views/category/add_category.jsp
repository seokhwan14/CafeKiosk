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
	<h3>메뉴 카테고리 추가</h3>
	<form action="after_add" method="post">
		<label>카테고리 명칭 : </label>	
		<input type="text" name="categoryName" required/><br>
		<input type="submit" value="추가하기"/>
	</form>
	<br><br>
	<form action="../cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지로 돌아가기">
	</form>
</body>
</html>