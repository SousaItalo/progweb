package br.ufc.controller.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.NoticiaDAO;
import br.ufc.model.javabeans.Noticia;

public class PaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("usuario") != null) {
			
			if(request.getParameter("pagina").equals("home.jsp")) {
				Connection connection = (Connection) request.getAttribute("connection");
			
				ServletContext context = request.getServletContext();
				NoticiaDAO noticiaDAO = new NoticiaDAO(connection);
				Noticia noticia = noticiaDAO.read();
				context.setAttribute("noticias", noticia);
			}
			
			String prefixo = "/WEB-INF/jsp/";
			String pagina = prefixo + request.getParameter("pagina");
			request.getRequestDispatcher(pagina).forward(request, response);
		} else {
			request.setAttribute("erro", "É necessário estar logado para acessar esse conteúdo.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
