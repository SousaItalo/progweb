package br.ufc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.ufc.model.javabeans.Livro;

public class LivroDAO {
	
	private Connection connection;
	
	public LivroDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void create(Livro livro) {
		String sqlLivros =  "INSERT INTO livros " +
					 		"(isbn,nome,genero,quantidade,ano_pub)" +
					 		"VALUES (?,?,?,?,?)";
		
		String sqlAutores = "INSERT INTO autores (id_livro,autor) VALUES (?,?)";
		
		try {
			PreparedStatement statementLivros = this.connection.prepareStatement(sqlLivros);
			
			statementLivros.setString(1, livro.getIsbn());
			statementLivros.setString(2, livro.getNome());
			statementLivros.setString(3, livro.getGenero());
			statementLivros.setInt(4, livro.getQuantidade());
			statementLivros.setInt(5, livro.getAnoPublicacao());
			
			statementLivros.execute();
			
			List<String> escritores = livro.getEscritores();
			for(String elemento : escritores) {
				PreparedStatement statementAutores = this.connection.prepareStatement(sqlAutores);
				statementAutores.setString(1, livro.getIsbn());
				statementAutores.setString(2, elemento);
				
				statementAutores.execute();
				statementAutores.close();
			}
			
			statementLivros.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(String isbn, int quantidade) {
		String sql = "UPDATE livros SET quantidade = quantidade + ? WHERE isbn = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, quantidade);
			statement.setString(2, isbn);
			
			statement.execute();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
