package br.ufc.controller.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.model.dao.UsuarioDAO;
import br.ufc.model.javabeans.Usuario;

public class CadastraUsuarioLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		Usuario usuario = new Usuario();
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setTipo(request.getParameter("tipo").charAt(0));
		usuario.setSexo(request.getParameter("sexo").charAt(0));
		usuario.setCep(request.getParameter("cep"));
		usuario.setRua(request.getParameter("rua"));
		usuario.setCidade(request.getParameter("cidade"));
		usuario.setEstado(request.getParameter("estado"));
		
		UsuarioDAO dao = new UsuarioDAO(connection);
		dao.create(usuario);
		
		return "cadastrar-usuario.jsp";
	}

}
