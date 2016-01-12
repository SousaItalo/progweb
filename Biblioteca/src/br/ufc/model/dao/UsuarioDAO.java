package br.ufc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufc.model.javabeans.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void create(Usuario usuario) {
		String sql = "INSERT INTO usuarios " +
					 "(cpf, nome, senha, telefone, tipo, sexo, cep, rua, cidade, estado)" +
					 "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setString(1, usuario.getCpf());
			statement.setString(2, usuario.getNome().toUpperCase());
			statement.setString(3, usuario.getSenha());
			statement.setString(4, usuario.getTelefone());
			statement.setString(5, String.valueOf(usuario.getTipo()));
			statement.setString(6, String.valueOf(usuario.getSexo()));
			statement.setString(7, usuario.getCep());
			statement.setString(8, usuario.getRua().toUpperCase());
			statement.setString(9, usuario.getCidade().toUpperCase());
			statement.setString(10, usuario.getEstado().toUpperCase());
			
			statement.execute();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario read(String cpf) {
		String sql = "SELECT * FROM usuarios " +
					 "WHERE cpf = ?";
		
		try {
			Usuario usuario = new Usuario();
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, cpf);
			
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setTelefone(resultado.getString("telefone"));
				usuario.setTipo(resultado.getString("tipo").charAt(0));
				usuario.setSexo(resultado.getString("sexo").charAt(0));
				usuario.setCep(resultado.getString("cep"));
				usuario.setRua(resultado.getString("rua"));
				usuario.setCidade(resultado.getString("cidade"));
				usuario.setEstado(resultado.getString("estado"));
				
				resultado.close();
				statement.close();
				
				return usuario;
			} else {
				resultado.close();
				statement.close();
				
				return null;
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Usuario usuario) {
		String sql = "UPDATE usuarios SET senha = ?,telefone = ?," +
					 "tipo = ?,cep = ?,rua = ?,cidade = ?,estado = ?" +
					 "WHERE cpf = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setString(1, usuario.getSenha());
			statement.setString(2, usuario.getTelefone());
			statement.setString(3, String.valueOf(usuario.getTipo()));
			statement.setString(4, usuario.getCep());
			statement.setString(5, usuario.getRua().toUpperCase());
			statement.setString(6, usuario.getCidade().toUpperCase());
			statement.setString(7, usuario.getEstado().toUpperCase());
			
			statement.execute();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Usuario usuario) {
		String sql = "DELETE FROM usuarios WHERE cpf = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, usuario.getCpf());
			
			statement.execute();
			statement.close();			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean permission(char tipo, String uri) {
		String sql = "SELECT uri FROM permissoes WHERE tipo = ? AND uri = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(tipo));
			statement.setString(2, uri);
			
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next())
				return true;
			else
				return false;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
