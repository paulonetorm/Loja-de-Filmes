<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Filmes</h1>

	<table border="1" id="minhaTabela">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Genero</th>
				<th>Diretor</th>
				<th>Data de Publica��o</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="filme" items="${filmes }">
				<tr>
					<td>${filme.titulo }</td>
					<td>${filme.genero }</td>
					<td>${filme.diretor }</td>
					<td><fmt:formatDate value="${filme.dataLancamento.time}" pattern="dd/MM/yyyy" /></td>
<%-- 					<td><a href="/filmesSpring/filmes/remover?id=${filme.id }">Remover</a></td> --%>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    
    <script>
  		$(document).ready(function(){
    	$('#minhaTabela').DataTable({
          		"language": {
                "lengthMenu": "Mostrando _MENU_ registros por p�gina",
                "zeroRecords": "Nada encontrado",
                "info": "Mostrando p�gina _PAGE_ de _PAGES_",
                "infoEmpty": "Nenhum registro dispon�vel",
                "infoFiltered": "(filtrado de _MAX_ registros no total)"
            }
        });
  });
  </script>
	
</body>
</html>