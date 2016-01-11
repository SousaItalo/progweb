<jsp:include page="header.jsp"/>
	<h1>Hístorico</h1>
	<%if(request.getAttribute("emprestimos") != null){ %>
		<table class="table table-striped">
			<thead>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	<%}%>
<jsp:include page="footer.jsp"/>