<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<title>BibWeb</title>
	</head>
	<body>
		<div class="container">
			<h1>Login</h1>
			<form action="ControllerServlet" method="post">
				CPF:<br>
				<input type="text" name="cpf" class="form-control"><br>
				Senha:<br>
				<input type="password" name="senha" class="form-control"><br>
				<input type="hidden" name="logica" value="LoginLogic">
				<input type="submit" value="Entrar">
			</form>
		</div>
	</body>
</html>