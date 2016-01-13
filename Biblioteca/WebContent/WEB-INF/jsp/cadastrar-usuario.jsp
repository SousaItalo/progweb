<jsp:include page="header.jsp"/>
	<div class="row">
		<div class="col-md-4">
		<h1>Cadastrar Usuário</h1>
			<form action=ControllerServlet method="post">
				Nome:<br>
				<input type="text" name="nome" class="form-control"><br>
				CPF:<br>
				<input type="text" name="cpf"class="form-control"><br>
				Senha:<br>
				<input type="password" name="senha" class="form-control"><br>
				Telefone:<br>
				<input type="text" name="telefone" class="form-control"><br>
				
				<div class="radio">
					Tipo:
					<label>
						<input type="radio" name="tipo" value="C" checked> 
						Cliente
				  	</label>
				  	<label>
				  	<input type="radio" name="tipo" value="F"> 
				  		Funcionário
				  	</label>
				  	<br/>
				  	Sexo:
				  	<label> 
				  		<input type="radio" name="sexo" value="M" checked> 
				  		Homem
				  	</label>
				  	<label>
				  		<input type="radio" name="sexo" value="F"> 
				  		Mulher
			  		</label>
			  		<br/>
			  	</div>
			  	
			  	CEP:<br>
			  	<input type="text" name="cep" class="form-control"><br>
			  	Rua:<br>
			  	<input type="text" name="rua" class="form-control"><br>
			  	Cidade:<br>
			  	<input type="text" name="cidade" class="form-control"><br>
			  	Estado:<br>
			  	<input type="text" name="estado" class="form-control"><br>
			  	<input type="hidden" name ="logica" value="CadastraUsuarioLogic">
			  	<input type="submit" value="Cadastrar" class="btn btn-default form-btn">
			</form>
		</div>
	</div>
<jsp:include page="footer.jsp"/>