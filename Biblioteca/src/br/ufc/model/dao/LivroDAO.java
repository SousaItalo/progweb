package br.ufc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public Livro readByISBN(String isbn) {
		String sqlLivros = "SELECT * FROM livros WHERE isbn = ?";
		
		String sqlAutores = "SELECT * FROM autores WHERE id_livro = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sqlLivros);
			
			statement.setString(1, isbn);
			
			ResultSet resultadoLivros = statement.executeQuery();
			
			if(resultadoLivros.next()) {
				Livro livro = new Livro();
				livro.setIsbn(resultadoLivros.getString("isbn"));
				livro.setNome(resultadoLivros.getString("nome"));
				livro.setGenero(resultadoLivros.getString("genero"));
				livro.setQuantidade(resultadoLivros.getInt("quantidade"));
				livro.setAnoPublicacao(resultadoLivros.getInt("ano_pub"));
				
				statement.clearParameters();
				statement = this.connection.prepareStatement(sqlAutores);
				
				statement.setString(1, isbn);
				
				ResultSet resultadoAutores = statement.executeQuery();
				
				List<String> autores = new ArrayList<>();
				while(resultadoAutores.next()) {
					autores.add(resultadoAutores.getString("autor"));
				}
				
				livro.setEscritores(autores);
				
				resultadoLivros.close();
				resultadoAutores.close();
				statement.close();
				
				return livro;
			}
			
			resultadoLivros.close();
			statement.close();
			
			return null;
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
