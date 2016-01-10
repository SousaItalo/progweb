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
	
	public List<Livro> read(String isbn, String nome, String genero, String autor) {
		String sql = "SELECT * FROM livros l, autores a " +	
					 "WHERE l.isbn = a.id_livro";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			int i = 0;
			if(isbn != null) {
				sql = sql + " AND isbn = ?";
				statement.setString(1, isbn);
			}
			if(nome != null) {
				i =+ 1;
				sql = sql + " AND nome LIKE ?";
				statement.setString(i, nome + "%");
			}
			if(genero != null) {
				i =+ 1;
				sql = sql + " AND genero LIKE ?";
				statement.setString(i, genero);
			}
			if(autor != null) {
				i =+ 1;
				sql = sql + " AND a.id_livro = (SELECT id_livro FROM autores WHERE autor = ?)";
				statement.setString(i, autor);
			}
			
			List<Livro> livros = new ArrayList<>();
			
			String ultimoISBN = null;
			Livro livro = null;
			List<String> autores = null;
			
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				if(ultimoISBN != resultado.getString("isbn")) {
					
					if(livro != null)
						livros.add(livro);
					
					livro = new Livro();
					livro.setIsbn(resultado.getString("isbn"));
					livro.setNome(resultado.getString("nome"));
					livro.setGenero(resultado.getString("genero"));
					livro.setQuantidade(resultado.getInt("quantidade"));
					livro.setAnoPublicacao(resultado.getInt("ano_pub"));
					
					autores = new ArrayList<>();
					autores.add(resultado.getString("autor"));

					livro.setEscritores(autores);
					
					ultimoISBN = resultado.getString("isbn");
				} else {
					autores.add(resultado.getString("autor"));
					
					livro.setEscritores(autores);
				}

				if(resultado.isLast())
					livros.add(livro);
			}
			resultado.close();
			statement.close();
			
			return livros;
			
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
