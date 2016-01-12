package br.ufc.controller.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.model.dao.EmprestimoDAO;
import br.ufc.model.javabeans.Emprestimo;

public class ConsultaEmprestimoLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("connection");
		
		EmprestimoDAO dao = new EmprestimoDAO(connection);
		List<Emprestimo> emprestimos = dao.read(request.getParameter("cpf"), false);
		for(Emprestimo e : emprestimos){
			e.setMulta();
		}
		request.setAttribute("emprestimos", emprestimos);
		
		return "devolucao.jsp";
	}

}
