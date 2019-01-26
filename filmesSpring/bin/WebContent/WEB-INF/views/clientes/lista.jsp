<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Lista de Clientes</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td>${cliente.nome }</td>
					<td>${cliente.email }</td>
					<td>${cliente.endereco }</td>
					<td><fmt:formatDate value="${cliente.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
					<td><a href="/filmesSpring/clientes/remover?id=${cliente.id }">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>