<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<jsp:include page="header.jsp"/>
	<h1>Hístorico</h1>
	<%if(request.getAttribute("emprestimos") != null){ %>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Nome</td>
					<td>Data de emprestimo</td>
					<td>Data de entrega</td>
					<td>Renovacoes</td>
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
					<td>${emprestimo.renovacoes}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<%}%>
<jsp:include page="footer.jsp"/>