<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Alterar Status</h1>
	<form action="/filmesSpring/vendas/alterar" method="post">
		<div>
			<input readonly="readonly" type="hidden" name="id" value="${venda.id }">
		</div>
		<div>
			<label>Status:</label> <input type="text" name="status" value="${venda.status }">
		</div>
		<div>
		<p></p>
			<button type="submit">Alterar</button>
		</div>
	</form>
</body>
</html>