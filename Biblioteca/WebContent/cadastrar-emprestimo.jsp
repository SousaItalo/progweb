<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Empréstimo</title>
</head>
<body>
	<h1>Cadastrar Empréstimo</h1>
	<form action="ControllerServlet" method="post">
	ISBN:<br>
	<input type="text" name="isbn"><br>
	CPF:<br>
	<input type="text" name="cpf"><br>
	Senha:<br>
	<input type="password" name="senha"><br>
	<input type="hidden" name="logica" value="CadastraEmprestimoLogic">
	<input type="submit" value="Cadastrar">
	</form>
</body>
</html>