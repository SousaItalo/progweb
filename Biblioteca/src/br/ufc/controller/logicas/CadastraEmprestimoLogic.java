package br.ufc.controller.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.EmprestimoDAO;
import br.ufc.model.dao.UsuarioDAO;
import br.ufc.model.javabeans.Emprestimo;
import br.ufc.model.javabeans.Usuario;

public class CadastraEmprestimoLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		Usuario funcionario = (Usuario) session.getAttribute("usuario");

		Connection connection = (Connection) request.getAttribute("connection");
		
		UsuarioDAO clienteDAO = new UsuarioDAO(connection);
		Usuario cliente = clienteDAO.read(request.getParameter("cpf"));
		
		if(cliente != null && cliente.getSenha().equals(request.getParameter("senha"))) {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setIdCliente(cliente.getCpf());
			emprestimo.setIdFuncionario(funcionario.getCpf());
			emprestimo.setRenovacoes(0);
			emprestimo.setIdLivro(request.getParameter("isbn"));
			
			EmprestimoDAO dao = new EmprestimoDAO(connection);
			dao.create(emprestimo);
			
			return "cadastrar-emprestimo.jsp";
		}
		
		return "cadastrar-emprestimo.jsp";
	}

}
