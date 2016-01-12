<jsp:include page="header.jsp"/>
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
<jsp:include page="footer.jsp"/>