<jsp:include page="header.jsp"/>
	<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<h1>Cadastrar Not�cia</h1>
					<form action="ControllerServlet" method="post">
						T�tulo da not�cia:<br/>
						<input type="text" name="titulo" class="form-control"><br/>
						Mensagem:<br/>
						<textarea rows="10" cols="76" name="descricao" class="form-control" maxlength="256"></textarea><br/>
						<input type="hidden" name="logica" value="CadastraNoticiaLogic">
						<input type="submit" value="Cadastrar" class="btn btn-default">
					</form>
				</div>
			</div>
		</div>
<jsp:include page="footer.jsp"/>