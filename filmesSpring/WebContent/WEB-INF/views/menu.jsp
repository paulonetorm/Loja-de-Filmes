<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>

<nav>
	<ul>
		<li><a href="/filmesSpring/">Home</a></li>
		<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">Clientes</a>
		<div class="dropdown-content">
		<a href="/filmesSpring/clientes/form" >Cadastrar Clientes</a>
		<a href="/filmesSpring/clientes">Lista de Clientes</a>
		</div> </li>
		<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">Filmes</a>
		<div class="dropdown-content">
		<a href="/filmesSpring/filmes/form">Adicionar Filmes</a>
		<a href="/filmesSpring/filmes">Lista de Filmes</a>
		<a href="/filmesSpring/filmes/listaRA">Remover Filmes</a>
		</div> </li>
		<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">Comprar</a>
		<div class="dropdown-content">
		<a href="/filmesSpring/vendas/form">Efetuar Compra</a>
		<a href="/filmesSpring/vendas">Lista de Compras</a>
		</div> </li>
	</ul>
</nav>


</br>