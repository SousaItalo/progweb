package br.ufc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/progweb?currentSchema=biblioteca";
        String usuario = "postgres";
        String senha = "admin";
        Connection connection = null;
        
        try {
        	Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
    }
}
