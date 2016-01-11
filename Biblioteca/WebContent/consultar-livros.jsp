<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
    <h1>Consulta de livros</h1>
    <div class="row">
        <div class="col-md-4">
	        <form action="ControllerServlet" method="post">
	            ISBN:<br/>
	            <input type="text" name="isbn"><br/>
	            Titulo do livro:<br/>
	            <input type="text" name="nome"><br/>
	            Nome do autor:<br/>
	            <input type="text" name="autor"><br/>
	            Genero:<br/>
	            <input type="text" name="genero"><br/>
	            <input type="hidden" name="logica" value="ConsultaLivroLogic">
	            <input type="submit" value="Consultar">
	        </form>
        </div>
        <% if(request.getAttribute("livros") != null){ %>
    	<div class="col-md-8">
    		<table id="consulta-livros" class="table table-striped">
    			<c:forEach items="${livros}" var="livro">
	    			<tr>
	    				<td>${livro.isbn}</td>
	    				<td>${livro.nome}</td>
	    				<td>${livro.genero}</td>
	    			<tr>
	    		</c:forEach>
    		</table>	  
    	</div>
  		<%}%>
    </div>
   	
<jsp:include page="footer.jsp"/>