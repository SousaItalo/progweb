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
			statementLivros.setString(2, livro.getNome().toUpperCase());
			statementLivros.setString(3, livro.getGenero().toUpperCase());
			statementLivros.setInt(4, livro.getQuantidade());
			statementLivros.setInt(5, livro.getAnoPublicacao());
			
			statementLivros.execute();
			
			List<String> escritores = livro.getEscritores();
			for(String elemento : escritores) {
				PreparedStatement statementAutores = this.connection.prepareStatement(sqlAutores);
				statementAutores.setString(1, livro.getIsbn());
				statementAutores.setString(2, elemento.toUpperCase());
				
				statementAutores.execute();
				statementAutores.close();
			}
			
			statementLivros.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Livro> read(String isbn, String nome, String genero, String autor) {
		String sql = "SELECT * FROM livros l, autores a WHERE l.isbn = a.id_livro";
		String sqlNome = " AND l.nome LIKE ?";
		String sqlGenero = " AND l.genero LIKE ?";
		String sqlAutor = "SELECT * FROM autores a, " +
						  "(SELECT l.isbn, l.nome, l.genero, l.quantidade, l.ano_pub FROM livros l, autores a1 " + 
						  "WHERE l.isbn = a1.id_livro and a1.autor LIKE ?) as l where a.id_livro = l.isbn";
		
		try {
			PreparedStatement statement = null;
			
			if(!isbn.equals("")) {
				statement = this.connection.prepareStatement(sql + " AND isbn = ?");
				statement.setString(1, isbn);
			} else {
				if(!nome.equals("") && genero.equals("") && autor.equals("")) { 
					statement = this.connection.prepareStatement(sql + sqlNome);
					statement.setString(1, nome.toUpperCase() + "%");
				}
				if(!nome.equals("") && !genero.equals("") && autor.equals("")) { 
					statement = this.connection.prepareStatement(sql + sqlNome + sqlGenero);
					statement.setString(1, nome.toUpperCase() + "%");
					statement.setString(2, genero.toUpperCase() + "%");
				}
				if(!nome.equals("") && genero.equals("") && !autor.equals("")) {
					statement = this.connection.prepareStatement(sqlAutor + sqlNome);
					statement.setString(1, autor.toUpperCase() + "%");
					statement.setString(2, nome.toUpperCase() + "%");
				}
				if(nome.equals("") && !genero.equals("") && autor.equals("")) {
					statement = this.connection.prepareStatement(sql + sqlGenero);
					statement.setString(1, genero.toUpperCase() + "%");
				}
				if(nome.equals("") && !genero.equals("") && !autor.equals("")) {
					statement = this.connection.prepareStatement(sqlAutor + sqlGenero);
					statement.setString(1, autor.toUpperCase() + "%");
					statement.setString(2, genero.toUpperCase() + "%");
				}
				if(nome.equals("") && genero.equals("") && !autor.equals("")) {
					statement = this.connection.prepareStatement(sqlAutor);
					statement.setString(1, autor.toUpperCase() + "%");
				}
				if(!nome.equals("") && !genero.equals("") && !autor.equals("")) {
					statement = this.connection.prepareStatement(sqlAutor + sqlNome + sqlGenero);
					statement.setString(1, autor.toUpperCase() + "%");
					statement.setString(2, nome.toUpperCase() + "%");
					statement.setString(3, genero.toUpperCase() + "%");
				}
			}
			
			List<Livro> livros = new ArrayList<>();
			
			String ultimoISBN = "";
			Livro livro = null;
			List<String> autores = null;
			
			ResultSet resultado = statement.executeQuery();
			if(!resultado.isBeforeFirst())
				return null;
			
			while(resultado.next()) {

				if(!resultado.getString("isbn").equals(ultimoISBN)) {

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
