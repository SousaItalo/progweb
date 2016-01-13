package br.ufc.controller.logicas;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.NoticiaDAO;
import br.ufc.model.dao.UsuarioDAO;
import br.ufc.model.javabeans.Noticia;
import br.ufc.model.javabeans.Usuario;

public class LoginLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("connection");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO(connection);
		Usuario usuario = dao.read(cpf);
		
		if(usuario != null && usuario.getSenha().equals(senha)) {
			
			if(request.getParameter("lembrar").equals("Lembrar")) {
				Cookie cookie = new Cookie("cookies.login", usuario.getCpf());
	            cookie.setMaxAge(60);
	            response.addCookie(cookie);
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			
			ServletContext context = request.getServletContext();
			NoticiaDAO noticiaDAO = new NoticiaDAO(connection);
			Noticia noticia = noticiaDAO.read();
			context.setAttribute("noticias", noticia);
			
			return "/WEB-INF/jsp/home.jsp";
		} else {
			request.setAttribute("erro", "Dados de acesso incorretos.");
			return "index.jsp";
		}
	}
}
