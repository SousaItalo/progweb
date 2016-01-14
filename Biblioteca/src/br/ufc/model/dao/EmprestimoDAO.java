package br.ufc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
			cal.add(Calendar.DATE, 14);
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

	public List<Emprestimo> read(String cpf, boolean ativo) {
		String sql = "SELECT * FROM emprestimo e, livros l WHERE e.id_livro = l.isbn AND id_cliente = ?"; 
		String order = " ORDER BY e.id_emprestimo DESC";
		if(!ativo) 
			sql = sql + " AND data_devolucao is null" + order;
		else
			sql = sql + order;
		
		try {
			List<Emprestimo> emprestimos = new ArrayList<>();
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, cpf);

			ResultSet resultado = statement.executeQuery();
			if(!resultado.isBeforeFirst())
				return null;
			
			while(resultado.next()) {
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setIdCliente(resultado.getString("id_cliente"));
				emprestimo.setIdFuncionario(resultado.getString("id_funcionario"));
				emprestimo.setRenovacoes(resultado.getInt("renovacoes"));
				emprestimo.setIdLivro(resultado.getString("id_livro"));
				emprestimo.setNomeLivro(resultado.getString("nome"));
				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(resultado.getDate("data_emprestimo"));
				emprestimo.setDataEmprestimo(dataEmprestimo);
				
				Calendar dataEntrega = Calendar.getInstance();
				dataEntrega.setTime(resultado.getDate("data_entrega"));
				emprestimo.setDataEntrega(dataEntrega);
				
				try {
					Calendar dataDevolucao = Calendar.getInstance();
					dataDevolucao.setTime(resultado.getDate("data_devolucao"));
					emprestimo.setDataDevolucao(dataDevolucao);
				} catch(NullPointerException e) {
					emprestimo.setDataDevolucao(null);
				}
				
				emprestimos.add(emprestimo);
			}
			
			resultado.close();
			statement.close();
			
			return emprestimos;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Emprestimo read(String cpf, String isbn) {
		String sql = "SELECT * FROM emprestimo e, livros l " +
					 "WHERE id_cliente = ? AND id_livro = ? AND data_devolucao is null";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setString(1, cpf);
			statement.setString(2, isbn);
			
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setIdCliente(resultado.getString("id_cliente"));
				emprestimo.setIdFuncionario(resultado.getString("id_funcionario"));
				emprestimo.setRenovacoes(resultado.getInt("renovacoes"));
				emprestimo.setIdLivro(resultado.getString("id_livro"));
				emprestimo.setNomeLivro(resultado.getString("nome"));
				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(resultado.getDate("data_emprestimo"));
				emprestimo.setDataEmprestimo(dataEmprestimo);
				
				Calendar dataEntrega = Calendar.getInstance();
				dataEntrega.setTime(resultado.getDate("data_entrega"));
				emprestimo.setDataEntrega(dataEntrega);
				
				emprestimo.setDataDevolucao(null);
				
				resultado.close();
				statement.close();
				
				return emprestimo;
			} else {
				resultado.close();
				statement.close();
				
				return null;
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Emprestimo emprestimo) {
		String sql = "UPDATE emprestimo SET renovacoes = ?," +
					 "data_devolucao = ?, data_entrega = ? " +
					 "WHERE id_livro = ? AND id_cliente = ? AND data_devolucao is null";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setInt(1, emprestimo.getRenovacoes());
			try {
				statement.setDate(2, new Date(emprestimo.getDataDevolucao().getTimeInMillis()));
			} catch(NullPointerException e) {
				statement.setDate(2, null);
			}
			statement.setDate(3, new Date(emprestimo.getDataEntrega().getTimeInMillis()));
			statement.setString(4, emprestimo.getIdLivro());
			statement.setString(5, emprestimo.getIdCliente());
			
			statement.execute();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
