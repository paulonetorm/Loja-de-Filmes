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

	<h1>Adicionar contato</h1>
	<form action="/filmesSpring/filmes" method="post">
		<div>
			<label>Titulo:</label> <input type="text" name="titulo">
		</div>
		<div>
			<label>Genero:</label> <input type="text" name="genero">
		</div>
		<div>
			<label>Diretor:</label> <input type="text" name="diretor">
		</div>
		<div>
			<label>Data de Publicação:</label> <input type="text"
				name="dataLancamento">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>

</body>
</html>