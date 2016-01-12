package br.ufc.controller.logicas;

import java.sql.Connection;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.model.dao.EmprestimoDAO;
import br.ufc.model.javabeans.Emprestimo;
import br.ufc.model.javabeans.Usuario;

public class RenovacaoLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		EmprestimoDAO dao = new EmprestimoDAO(connection);
		Emprestimo emprestimo = dao.read(usuario.getCpf(), request.getParameter("isbn"));
		
		Calendar novaEntrega = emprestimo.getDataEntrega();
		novaEntrega.add(Calendar.DATE, 14);
		
		emprestimo.setDataEntrega(novaEntrega);
		emprestimo.setRenovacoes(emprestimo.getRenovacoes() + 1);
		
		dao.update(emprestimo);
		
		return "ControllerServlet?logica=ConsultaHistoricoLogic";
	}
}
