<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
	<%br.ufc.model.javabeans.Noticia noticia = (br.ufc.model.javabeans.Noticia) request.getServletContext().getAttribute("noticias");%>
	<div class="row">
		<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<%if(noticia != null) {%>
					<div class="row">
						<h3>
							<%=noticia.getTitulo()%>
						</h3>	
					</div>
					<div class="row corpo-noticia">
						<%=noticia.getDescricao()%>
					</div>
				<%} else {%>
					<div class="row">
						<h4>Não há notícias.</h4>					
					</div>
				<%} %>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"/>