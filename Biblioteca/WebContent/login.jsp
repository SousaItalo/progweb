<jsp:include page="header.jsp"/>
	<h1>Login</h1>
	<form action="ControllerServlet" method="post">
	CPF:<br>
	<input type="text" name="cpf"><br>
	Senha:<br>
	<input type="password" name="senha"><br>
	<input type="hidden" name="logica" value="LoginLogic">
	<input type="submit" value="Entrar">
	</form>
<jsp:include page="footer.jsp"/>