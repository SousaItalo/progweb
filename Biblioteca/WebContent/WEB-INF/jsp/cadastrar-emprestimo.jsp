<jsp:include page="header.jsp"/> 
<div class="row">
	<div class="col-md-6 col-md-offset-2">
		<h1>Cadastrar Empréstimo</h1>
		<form action="ControllerServlet" method="post">
		    CPF:<br>
		    <input type="text" name="cpf" maxlength="11" onkeypress="return SomenteNumero(event)" class="form-control"><br>
		    Senha:<br>
		    <input type="password" name="senha" class="form-control"><br>
		    Código do(s) livro(s):<br>
		    <table id="tabela-livros">
		        <tr>
		            <td><input type="text" name="isbn" class="form-control"></td>
		            <td onclick="addCampo('isbn')" class="btn btn-default">	&nbsp;<span class="glyphicon glyphicon glyphicon-plus" aria-hidden="true"></span></td>
		        </tr>
		    </table>
		    <input type="hidden" name="logica" value="CadastraEmprestimoLogic">
		    <br/>
		    <input type="submit" value="Cadastrar" class="btn btn-default">
		</form>
	</div>
</div>
<jsp:include page="footer.jsp"/>