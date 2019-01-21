<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>
<table border="1">
		<thead>
			<tr>
				
				<th>Nome</th>
				<th>Filme</th>
				<th>Data da Compra</th>
				<th>Status	</th>
			
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="venda" items="${vendas }">
				<tr>
					<td>${venda.cliente.nome}</td>
					<td>${venda.filme.titulo}</td>
					<td><fmt:formatDate value="${venda.dataVenda.time}" pattern="dd/MM/yyyy" /></td>
					<td>${venda.status}</td>
					<td><a href="/filmesSpring/vendas/selecionar?id=${venda.id }">Alterar Status</a></td>
					
					
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>