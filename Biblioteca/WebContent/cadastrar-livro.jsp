<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>Cadastrar Livro</h1>
	<form action="ControllerServlet" method="post">
		Título:<br> 
		<input type="text" name="titulo"><br>
		ISBN:<br>
		<input type="text" name="isbn"><br>
		Genero:<br>
		<input type="text" name="genero"><br>
		Quantidade:<br>
		<input type="text" name="quantidade"><br>
		Data de Publicação:<br>
		<input type="text" name="data"><br>
		Autores:<br>
		<table>
			<tr>
				<td><input type="text" name="autor1"></td>
			</tr>
			<tr>
				<td><input type="text" name="autor2"></td>
			</tr>
		</table>
		<input type="hidden" name ="logica" value="CadastraLivroLogic">
	  	<input type="submit" value="Cadastrar">
	</form>	
</body>
</html>