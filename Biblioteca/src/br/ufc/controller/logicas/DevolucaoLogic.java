package br.ufc.controller.logicas;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.model.dao.EmprestimoDAO;
import br.ufc.model.javabeans.Emprestimo;

public class DevolucaoLogic implements ILogica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("connection");
		
		EmprestimoDAO dao = new EmprestimoDAO(connection);
		
		Emprestimo emprestimo = dao.read(request.getParameter("cpf"), request.getParameter("isbn"));
		
		if(emprestimo != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(System.currentTimeMillis()));
			emprestimo.setDataDevolucao(cal);
			
			dao.update(emprestimo);
			
			return "devolucao.jsp";
		}
		
		return "devolucao.jsp";
	}
}
