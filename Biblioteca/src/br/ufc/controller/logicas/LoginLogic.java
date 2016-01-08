package br.ufc.controller.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.UsuarioDAO;
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
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			return "cadastrar-livro.jsp";
		} else {
			return "login.jsp"; 
		}
	}
}
