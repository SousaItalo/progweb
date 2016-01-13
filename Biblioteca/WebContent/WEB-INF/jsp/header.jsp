<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BibWeb</title>
    <link href="/Biblioteca/css/bootstrap.min.css" rel="stylesheet">
     <link href="/Biblioteca/css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="topo">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
			<ul id="menu-principal" class="nav navbar-nav navbar-right">
				<li><a href="ControllerServlet?logica=ConsultaHistoricoLogic">Historico</a></li>		
				<li><a href="PaginaServlet?pagina=consultar-livros.jsp">Consultar Acervo</a></li>
				<%
					br.ufc.model.javabeans.Usuario user = (br.ufc.model.javabeans.Usuario)session.getAttribute("usuario");
					if(user.getTipo() == 'F'){
				%>
					<li><a href="PaginaServlet?pagina=devolucao.jsp">Devolucao</a></li>
					<li><a href="PaginaServlet?pagina=cadastrar-usuario.jsp">Cadastrar Usuario</a></li>
					<li><a href="PaginaServlet?pagina=cadastrar-livro.jsp">Cadastrar Livro</a></li>
					<li><a href="PaginaServlet?pagina=cadastrar-emprestimo.jsp">Realizar Empresitmo</a></li>
				<%}%>	
			</ul>
			</div>	
		</nav>
	</div>
	<div class="container">