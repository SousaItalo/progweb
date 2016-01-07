package br.ufc.controller.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ILogica {

	String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
