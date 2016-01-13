package br.ufc.controller.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.model.dao.NoticiaDAO;
import br.ufc.model.javabeans.Noticia;

public class CadastraNoticiaLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("connection");
		
		Noticia noticia = new Noticia();
		noticia.setTitulo(request.getParameter("titulo"));
		noticia.setDescricao(request.getParameter("descricao"));
		
		NoticiaDAO dao = new NoticiaDAO(connection);
		dao.create(noticia);
		
		return "/WEB-INF/jsp/home.jsp";
	}

}
