package br.ufc.controller.logicas;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.EmprestimoDAO;
import br.ufc.model.dao.LivroDAO;
import br.ufc.model.dao.UsuarioDAO;
import br.ufc.model.javabeans.Emprestimo;
import br.ufc.model.javabeans.Usuario;

public class CadastraEmprestimoLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Recupera o funcion�rio que est� realizando o empr�stimo pela sess�o.
		HttpSession session = request.getSession(false);
		Usuario funcionario = (Usuario) session.getAttribute("usuario");

		//Recupera a conex�o com o banco setada no FiltroConexao.
		Connection connection = (Connection) request.getAttribute("connection");
		
		//Realiza uma busca pelo cpf do cliente.
		UsuarioDAO clienteDAO = new UsuarioDAO(connection);
		Usuario cliente = clienteDAO.read(request.getParameter("cpf"));
		
		//Caso o cliente esteja cadastrado e tenha entrado a senha correta.
		if(cliente != null && cliente.getSenha().equals(request.getParameter("senha"))) {
			LivroDAO livroDAO = new LivroDAO(connection);
			EmprestimoDAO empDAO = new EmprestimoDAO(connection);
			List<String> erros = new ArrayList<>();
			
			List<Emprestimo> emprestimosAtivos = empDAO.read(cliente.getCpf(), false);
			if(emprestimosAtivos != null && (emprestimosAtivos.size() + request.getParameterValues("isbn").length) > 5) {
				request.setAttribute("erro", "O cliente j� tem " + emprestimosAtivos.size() + " empr�stimos ativos.");
				return "/WEB-INF/jsp/cadastrar-emprestimo.jsp";
			}
			
			//Para cada livro que o cliente esteja alugando.
			for(String isbn : request.getParameterValues("isbn")) {
				//Busca a exist�ncia de um empr�stimo do mesmo livro que esteja em aberto.
				Emprestimo emprestimo = empDAO.read(cliente.getCpf(), isbn);
				
				//Caso esse empr�stimo n�o exista.
				if(emprestimo == null) {
					emprestimo = new Emprestimo();
					emprestimo.setIdCliente(cliente.getCpf());
					emprestimo.setIdFuncionario(funcionario.getCpf());
					emprestimo.setRenovacoes(0);
					emprestimo.setIdLivro(isbn);
					
					//Atualiza��o no estoque de livros, e inser��o do empr�stimo.
					livroDAO.update(isbn, -1);
					empDAO.create(emprestimo);
				} else {
					erros.add(emprestimo.getNomeLivro());
				}
			}
			
			if(!erros.isEmpty())
				request.setAttribute("mensagemLivros", erros);
			
		} else {
			request.setAttribute("mensagemDados", "Dados do cliente incorretos.");
		}
		
		return "/WEB-INF/jsp/cadastrar-emprestimo.jsp";
	}
}
