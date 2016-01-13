package br.ufc.controller.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.controller.logicas.ILogica;
import br.ufc.model.dao.NoticiaDAO;
import br.ufc.model.javabeans.Noticia;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recebe parametro logica do request e gera o nome da classe responsável pela mesma.
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.ufc.controller.logicas." + parametro;
		
		ServletContext context = this.getServletContext();
		if(context.getAttribute("noticias") == null) {
			Connection connection = (Connection) request.getAttribute("connection");
			NoticiaDAO dao = new NoticiaDAO(connection);
			Noticia noticia = dao.read();
			context.setAttribute("noticias", noticia);
		}
			
		try {
			//Obtem a classe.
			Class<?> classe = Class.forName(nomeDaClasse);
			
			//Cria uma nova instância da classe, usando polimorfismo.
			ILogica logica = (ILogica) classe.newInstance();
			
			//Recebe a string como retorno do método executa da interface.
			String pagina = logica.executa(request, response);
			
			//Forward para a página. 
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

}
