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
		Título:<br/> 
		<input type="text" name="titulo">
		ISBN:<br/>
		<input type="text" name="isbn">
		Genero:<br/>
		<input type="text" name="genero">
		Quantidade:<br/>
		<input type="text" name="quantidade">
		Data de Publicação:<br/>
		<input type:"text" name="data">
	</form>	
</body>
</html>