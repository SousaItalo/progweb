package br.ufc.controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String prefixo = "/WEB-INF/jsp/";
		String pagina = prefixo + request.getParameter("pagina");
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}

}
