<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<jsp:include page="header.jsp"/>
    <h1>Consulta de livros</h1>
    <div class="row">
        <form action="ControllerServlet" method="post">
            ISBN:<br/>
            <input type="text" name="isbn"><br/>
            Titulo do livro:<br/>
            <input type="text" name="nome"><br/>
            Nome do autor:<br/>
            <input type="text" name="autor"><br/>
            Genero:<br/>
            <input type="text" name="genero"><br/>
            <input type="hidden" name="ConsultaLivroLogic">
            <input type="submit" value="Consultar">
        </form>
    </div>
   	
   	<% if(request.getAttribute("livros") != null){ %>
    	<div class="row">
    		<table id="consulta-livros">
    			<c:forEach items="${list}" var="livro">
	    			<tr>
	    				<td></td>
	    			<tr>
	    		</c:forEach>
    		</table>	  
    	</div>
  	<%}%>
<jsp:include page="footer.jsp"/>