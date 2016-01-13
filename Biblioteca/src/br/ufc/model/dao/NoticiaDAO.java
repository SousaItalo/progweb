package br.ufc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufc.model.javabeans.Noticia;

public class NoticiaDAO {
	private Connection connection;
	
	public NoticiaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void create(Noticia noticia) {
		String sql = "INSERT INTO noticias (titulo,descricao) VALUES(?,?)";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, noticia.getTitulo());
			statement.setString(2, noticia.getDescricao());
			
			statement.execute();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Noticia read() {
		String sql = "SELECT * FROM noticias WHERE id_noticia = (SELECT MAX(id_noticia) FROM noticias)";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next()) {
				Noticia noticia = new Noticia();
				noticia.setTitulo(resultado.getString("titulo"));
				noticia.setDescricao(resultado.getString("descricao"));
				
				resultado.close();
				statement.close();
				
				return noticia;
			} else {
				return null;
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
