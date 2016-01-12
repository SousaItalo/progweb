<jsp:include page="header.jsp"/>
	<h1>Cadastrar Usuário</h1>
	<form action=ControllerServlet method="post">
		Nome:<br>
		<input type="text" name="nome"><br>
		CPF:<br>
		<input type="text" name="cpf"><br>
		Senha:<br>
		<input type="password" name="senha"><br>
		Telefone:<br>
		<input type="text" name="telefone"><br>
		Tipo: 
		<input type="radio" name="tipo" value="C" checked> Cliente
	  	<input type="radio" name="tipo" value="F"> Funcionário<br>
	  	Sexo: 
	  	<input type="radio" name="sexo" value="M" checked> Homem
	  	<input type="radio" name="sexo" value="F"> Mulher<br>
	  	CEP:<br>
	  	<input type="text" name="cep"><br>
	  	Rua:<br>
	  	<input type="text" name="rua"><br>
	  	Cidade:<br>
	  	<input type="text" name="cidade"><br>
	  	Estado:<br>
	  	<input type="text" name="estado"><br>
	  	<input type="hidden" name ="logica" value="CadastraUsuarioLogic">
	  	<input type="submit" value="Cadastrar">
	</form>
<jsp:include page="footer.jsp"/>