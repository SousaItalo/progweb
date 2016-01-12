package br.ufc.controller.logicas;

import java.sql.Connection;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.model.dao.LivroDAO;
import br.ufc.model.javabeans.Livro;

public class CadastraLivroLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("connection");
		
		Livro livro = new Livro();
		livro.setIsbn(request.getParameter("isbn"));
		livro.setNome(request.getParameter("titulo"));
		livro.setGenero(request.getParameter("genero"));
		livro.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		livro.setEscritores(Arrays.asList(request.getParameterValues("autor")));
		livro.setAnoPublicacao(Integer.parseInt(request.getParameter("data")));
		
		LivroDAO dao = new LivroDAO(connection);
		dao.create(livro);
		
		return "/WEB-INF/jsp/cadastrar-livro.jsp";
	}

}
