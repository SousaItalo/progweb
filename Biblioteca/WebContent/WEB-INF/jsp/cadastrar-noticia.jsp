<jsp:include page="header.jsp"/>
	<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<h1>Cadastrar Notícia</h1>
					<form action="ControllerServlet" method="post">
						Título da notícia:<br/>
						<input type="text" name="titulo" class="form-control"><br/>
						Mensagem:<br/>
						<input type="text" name="descricao" class="form-control"><br/>
						<input type="hidden" name="logica" value="CadastraNoticiaLogic">
						<input type="submit" value="Cadastrar" class="btn btn-default">
					</form>
				</div>
			</div>
		</div>
<jsp:include page="footer.jsp"/>