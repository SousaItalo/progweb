<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<title>BibWeb</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<h1>Login</h1>
					<form action="ControllerServlet" method="post">
						CPF:<br>
						
						<% String loginCookie = ""; %>
                		<%
                    		Cookie[] cookies = request.getCookies();
                    		if (cookies != null) {
                        		for (Cookie c : cookies) {
                            		if (c.getName().equals("cookies.login")) {
                               			loginCookie = c.getValue();
                                		break;
                           			}
                        		}
                    		}
                		%>
						
						<input type="text" name="cpf" value="<%= loginCookie%>" class="form-control"><br>
						Senha:<br>
						<input type="password" name="senha" class="form-control"><br>
						<input type="checkbox" name="lembrar" value="Lembrar"> Lembrar<br>
						<input type="hidden" name="logica" value="LoginLogic">
						<input type="submit" value="Entrar" class="btn btn-default">
					</form>
					<% if(request.getAttribute("erro") != null) {%>
					<%= request.getAttribute("erro") %>
					<%}%>
				</div>
			</div>
		</div>
	</body>
</html>