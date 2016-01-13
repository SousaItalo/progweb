package br.ufc.controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.controller.logicas.ILogica;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recebe parametro logica do request e gera o nome da classe respons�vel pela mesma.
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.ufc.controller.logicas." + parametro;
		
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("usuario") == null && (parametro == null || !parametro.equals("LoginLogic"))) {
			request.setAttribute("erro", "� necess�rio estar logado para acessar esse conte�do.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		try {
			//Obtem a classe.
			Class<?> classe = Class.forName(nomeDaClasse);
			
			//Cria uma nova inst�ncia da classe, usando polimorfismo.
			ILogica logica = (ILogica) classe.newInstance();
			
			//Recebe a string como retorno do m�todo executa da interface.
			String pagina = logica.executa(request, response);
			
			//Forward para a p�gina. 
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

}
