package br.ufc.filters;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.UsuarioDAO;
import br.ufc.model.javabeans.Usuario;

public class FiltroUsuario implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {

		Connection connection = (Connection) request.getAttribute("connection");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		if(session != null) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			UsuarioDAO dao = new UsuarioDAO(connection);
			if(dao.permission(usuario.getTipo(), req.getRequestURI()))
				fc.doFilter(request, response);
			else
				res.sendRedirect("/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}

}
