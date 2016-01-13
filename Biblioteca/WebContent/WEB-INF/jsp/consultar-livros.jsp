<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
    <h1>Consulta de livros</h1>
    <div class="row">
        <div class="col-md-4">
	        <form action="ControllerServlet" method="post">
	            ISBN:<br/>
	            <input type="text" name="isbn" class="form-control"><br/>
	            Titulo do livro:<br/>
	            <input type="text" name="nome" class="form-control"><br/>
	            Nome do autor:<br/>
	            <input type="text" name="autor" class="form-control"><br/>
	            Genero:<br/>
	            <input type="text" name="genero" class="form-control"><br/>
	            <input type="hidden" name="logica" value="ConsultaLivroLogic">
	            <input type="submit" value="Consultar" class="btn btn-default">
	        </form>
        </div>
        <% if(request.getAttribute("livros") != null){ %>
    	<div class="col-md-8">
    		<table id="consulta-livros" class="table table-striped">
    			<thead>
    				<tr>
    					<td>Isbn</td>
    					<td>Nome</td>
    					<td>Genero</td>
    					<td>Ano de pulicacao</td>
    					<td>Exemplares disponiveis</td>
    					<td>Autores</td>
    				</tr>
    			</thead>
    			<c:forEach items="${livros}" var="livro">
	    			<tr>
	    				<td>${livro.isbn}</td>
	    				<td>${livro.nome}</td>
	    				<td>${livro.genero}</td>
	    				<td>${livro.anoPublicacao}</td>
	    				<td>${livro.quantidade}</td>
	    				<td><c:forEach items="${livro.escritores}" var="autor">${autor} </c:forEach></td>
	    			<tr>
	    		</c:forEach>
    		</table>	  
    	</div>
  		<%}%>
    </div>
   	
<jsp:include page="footer.jsp"/>