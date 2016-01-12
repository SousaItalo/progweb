package br.ufc.controller.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.EmprestimoDAO;
import br.ufc.model.javabeans.Emprestimo;
import br.ufc.model.javabeans.Usuario;

public class ConsultaHistoricoLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(connection);
		List<Emprestimo> emprestimos = emprestimoDAO.read(usuario.getCpf(), true);
		
		//calcula as multas de todos os emprestimos retornados da chamada acima
		for(Emprestimo e: emprestimos){
			e.setMulta();
		}

		request.setAttribute("emprestimos", emprestimos);
		
		return "consultar-historico.jsp";
	}

}
