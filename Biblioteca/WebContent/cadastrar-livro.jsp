<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastrar livro</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>Cadastrar Livro</h1>
	<form action="ControllerServlet" method="post">
        Título:<br> 
		<input type="text" name="titulo"><br>
		ISBN:<br>
		<input type="text" name="isbn" maxlength="13" onkeypress="return SomenteNumero(event)"><br>
		Genero:<br>
		<input type="text" name="genero"><br>
		Quantidade:<br>
		<input type="text" name="quantidade" onkeypress="return SomenteNumero(event)"><br>
		Data de Publicação:<br>
		<input type="text" maxlength="4" name="data" onkeypress="return SomenteNumero(event)"><br>
		Autores:<br>
		<div id="tabela-autores">
			<table id="tabela-livros">
				<tr>
					<td><input type="text" name="autor"></td>
					<td onclick="addCampo('autor')">Add Autor</td>
				</tr>
			</table>
		</div>
		<input type="hidden" name ="logica" value="CadastraLivroLogic">
	  	<input type="submit" value="Cadastrar">
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="main.js"></script>	
</body>
</html>