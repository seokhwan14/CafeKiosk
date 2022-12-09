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
	<h3>현재 카테고리 목록</h3>
	<form method="post" action="search_category">
	
		<table border="1">
			<tr>
				<th> 목록 순번 </th>
				<th> 카테고리 명칭 </th>
			</tr>
		<c:forEach var="category" items="${CategoryProviderList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><c:out value="${category}"/></td>
			</tr>
		</c:forEach>		
		</table><br>
	</form>
	<br>
	<form action="../cafeManager/managementPage" method="get">
		<input type="submit" value="관리자 페이지로 돌아가기"/>
	</form>	
	<br><br>
	<form action="../index" method="get">
		<input type="submit" value="메인 화면으로 돌아가기">
	</form>
</body>
</html>