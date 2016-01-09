<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cadastrar Empréstimo</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h1>Cadastrar Empréstimo</h1>
    <form action="ControllerServlet" method="post">
        CPF:<br>
        <input type="text" name="cpf"><br>
        Senha:<br>
        <input type="password" name="senha"><br>
        Código do(s) livro(s):<br>
        <table id="tabela-livros">
            <tr>
                <td><input type="text" name="isbn"><br></td>
                <td onclick="addCampo('Livro')">Add Livro</td>
            </tr>
        </table>
        <input type="hidden" name="logica" value="CadastraEmprestimoLogic">
        <input type="submit" value="Cadastrar">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="main.js"></script>	
	</form>
</body>
</html>