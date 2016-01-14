<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<jsp:include page="header.jsp"/>
	<h1>Histórico</h1>
	<%if(request.getAttribute("emprestimos") != null){ %>
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
					<td>${emprestimo.renovacoes} / 10</td>
					<td><form action="ControllerServlet" method="post">
							<input type="hidden" name="isbn" value="${emprestimo.idLivro}">
							<input type="hidden" name="logica" value="RenovacaoLogic">
							<c:if test="${emprestimo.multa == 0 && emprestimo.dataDevolucao == null}">
								<input type="submit" value="Renovar" class="btn btn-success" role="button">
							</c:if>
							<c:if test="${emprestimo.multa > 0 || emprestimo.dataDevolucao != null}">
								<input type="submit" value="Renovar" class="btn btn-default disabled" role="button">
							</c:if>
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<%}%>
<jsp:include page="footer.jsp"/>