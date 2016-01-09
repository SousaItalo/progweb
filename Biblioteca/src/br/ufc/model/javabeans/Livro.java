package br.ufc.model.javabeans;

import java.util.List;

public class Livro {
	private String isbn;
	private String nome;
	private String genero;
	private int quantidade;
	private int anoPublicacao;
	private List<String> escritores;
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	/**
	 * @return the anoPublicacao
	 */
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	/**
	 * @param anoPublicacao the anoPublicacao to set
	 */
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	/**
	 * @return the escritores
	 */
	public List<String> getEscritores() {
		return escritores;
	}
	/**
	 * @param escritores the escritores to set
	 */
	public void setEscritores(List<String> escritores) {
		this.escritores = escritores;
	
	}
	
}
