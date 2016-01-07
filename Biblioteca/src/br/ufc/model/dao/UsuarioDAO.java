package br.ufc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.model.javabeans.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Usuario usuario) {
		String sql = "INSERT INTO usuarios " +
					 "(cpf, nome, senha, telefone, tipo, sexo, cep, rua, cidade, estado)" +
					 "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setString(1, usuario.getCpf());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getSenha());
			statement.setString(4, usuario.getTelefone());
			statement.setString(5, String.valueOf(usuario.getTipo()));
			statement.setString(6, String.valueOf(usuario.getSexo()));
			statement.setString(7, usuario.getCep());
			statement.setString(8, usuario.getRua());
			statement.setString(9, usuario.getCidade());
			statement.setString(10, usuario.getEstado());
			
			statement.execute();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
