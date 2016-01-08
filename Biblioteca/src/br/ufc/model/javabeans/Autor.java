package br.ufc.model.javabeans;

import java.util.ArrayList;

public class Autor {
	private String idLivro;
	private ArrayList<Integer> idAutor = new ArrayList<Integer>();
	/**
	 * @return the idLivro
	 */
	public String getIdLivro() {
		return idLivro;
	}
	/**
	 * @param idLivro the idLivro to set
	 */
	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}
	/**
	 * @return the idAutor
	 */
	public ArrayList<Integer> getIdAutor() {
		return idAutor;
	}
	/**
	 * @param idAutor the idAutor to set
	 */
	public void setIdAutor(int id) {
		this.idAutor.add(id);
	
	}
}
