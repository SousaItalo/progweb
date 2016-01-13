<jsp:include page="header.jsp"/>
	<div class="row">
		<div class="col-md-6 col-md-offset-2">
			<h1>Cadastrar Livro</h1>
			<form action="ControllerServlet" method="post">
		        Título:<br> 
				<input type="text" name="titulo" class="form-control"><br>
				ISBN:<br>
				<input type="text" name="isbn" maxlength="13" onkeypress="return SomenteNumero(event)" class="form-control"><br>
				Genero:<br>
				<input type="text" name="genero" class="form-control"><br>
				Quantidade:<br>
				<input type="text" name="quantidade" onkeypress="return SomenteNumero(event)" class="form-control"><br>
				Data de Publicação:<br>
				<input type="text" maxlength="4" name="data" onkeypress="return SomenteNumero(event)" class="form-control"><br>
				Autores:<br>
				<div id="tabela-autores">
					<table id="tabela-livros">
						<tr>
							<td><input type="text" name="autor" class="form-control"></td>
							<td onclick="addCampo('autor')">Add Autor</td>
						</tr>
					</table>
				</div>
				<input type="hidden" name ="logica" value="CadastraLivroLogic">
			  	<input type="submit" value="Cadastrar">
			</form>
		</div>
	</div>
<jsp:include page="footer.jsp"/>