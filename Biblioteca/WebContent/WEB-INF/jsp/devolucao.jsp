<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<jsp:include page="header.jsp"/>
	<div class="row">
		<div class="col-md-4">
			<h1>Devolução</h1>
			<form action="ControllerServlet" method="post">
				CPF do cliente:<br/>
				<input type="text" name="cpf" class="form-control"><br/>
				<input type="hidden" name="logica" value="ConsultaEmprestimoLogic">
				<input type="submit" value="Pesquisar" class="btn btn-default">
			</form>
		</div>
		<%if(request.getAttribute("emprestimos") != null){ %>
		<div class="col-md-8">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Nome</td>
						<td>Data de empréstimo</td>
						<td>Data de entrega</td>
						<td>Multa</td>
						<td>Renovações</td>
						<td>#</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${emprestimos}" var="emprestimo">
					<tr>
						<td>${emprestimo.nomeLivro}</td>
						<fmt:formatDate value="${emprestimo.dataEmprestimo.time}" type="date" dateStyle="short" var="emprestimoData"/>
						<td>${emprestimoData}</td>
						<fmt:formatDate value="${emprestimo.dataEntrega.time}" type="date" dateStyle="short" var="entregaData"/>
						<td>${entregaData}</td>
						<td>${emprestimo.multa}</td>
						<td>${emprestimo.renovacoes}</td>
						<td>
							<form action="ControllerServlet" method="post">
								<input type="hidden" name="cpf" value="${emprestimo.idCliente}">
								<input type="hidden" name="isbn" value="${emprestimo.idLivro}">
								<input type="hidden" name="logica" value="DevolucaoLogic">
								<c:if test="${emprestimo.multa==0}">
									<input type="submit" value="Devolver" class="btn btn-default">
								</c:if>
								<c:if test="${emprestimo.multa>0}">
									<input type="submit" value="Devolver" class="btn btn-danger">
								</c:if>
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
		<%}%>
	</div>
<jsp:include page="footer.jsp"/>