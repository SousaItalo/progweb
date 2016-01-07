package br.ufc.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.ufc.util.ConnectionFactory;

public class FiltroConexao implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {
		
		try {
			//Abre uma conex�o com o banco.
			Connection connection = new ConnectionFactory().getConnection();
			
			//Seta a conex�o como um atributo do request.
			request.setAttribute("connection", connection);
			
			//Prossegue o processamento do request.
			fc.doFilter(request, response);
			
			//Ap�s o processamento do request, fecha a conex�o.
			connection.close();
		} catch(SQLException e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}

}
