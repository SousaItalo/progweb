package br.ufc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.ufc.model.javabeans.Emprestimo;

public class EmprestimoDAO {
	private Connection connection;
	
	public EmprestimoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void create(Emprestimo emprestimo) {
		String sql = "INSERT INTO emprestimo " +
					 "(id_cliente,id_funcionario,data_emprestimo,renovacoes,data_devolucao,data_entrega,id_livro)" +
					 "VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			java.util.Date hoje = new java.util.Date(System.currentTimeMillis());
			Calendar cal = Calendar.getInstance();
			cal.setTime(hoje);
			cal.add(Calendar.DATE, 10);
			java.util.Date entrega = cal.getTime();
			
			statement.setString(1, emprestimo.getIdCliente());
			statement.setString(2, emprestimo.getIdFuncionario());
			statement.setDate(3, new Date(hoje.getTime()));
			statement.setInt(4, emprestimo.getRenovacoes());
			statement.setNull(5, java.sql.Types.DATE);
			statement.setDate(6, new Date(entrega.getTime()));
			statement.setString(7, emprestimo.getIdLivro());
			
			statement.execute();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
