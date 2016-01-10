package br.ufc.controller.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.model.dao.LivroDAO;
import br.ufc.model.javabeans.Livro;

public class ConsultaLivroLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("connection");
		
		String isbn = request.getParameter("isbn");
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		String autor = request.getParameter("autor");
		
		LivroDAO dao = new LivroDAO(connection);
		List<Livro> livros = dao.read(isbn, nome, genero, autor);
		
		request.setAttribute("livros", livros);
		return "consultar-livros.jsp";
	}

}
