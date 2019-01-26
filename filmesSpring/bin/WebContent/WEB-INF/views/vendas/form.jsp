<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:import url="../menu.jsp"></c:import>
		<h1>Compras</h1>
		<form action="/filmesSpring/vendas" method="post">
		<div>
			<label>Seu Nome:</label> 
			<select name="cliente.id">
				<c:forEach var="cliente" items="${clientes }">
					<option value="${cliente.id }">${cliente.nome }</option>
				</c:forEach>
			</select>
			<select name="filme.id">
				<c:forEach var="filme" items="${filmes }">
					<option value="${filme.id }">${filme.titulo }</option>
				</c:forEach>
			</select>
		</div>
			<button type="submit">Adicionar</button>
		</form> 
	</body>
</html>