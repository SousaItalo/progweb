package br.ufc.model.javabeans;

import java.util.ArrayList;
import java.util.Calendar;

public class Livro {
	private String isbn;
	private String nome;
	private String genero;
	private int quantidade;
	private Calendar dataPublicacao;
	private ArrayList<String> escritores = new ArrayList<String>();
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
	 * @return the dataPublicacao
	 */
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}
	/**
	 * @param dataPublicacao the dataPublicacao to set
	 */
	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public ArrayList<String> getIdAutor() {
		return escritores;
	}
	/**
	 * @param idAutor the idAutor to set
	 */
	public void setIdAutor(String nome) {
		this.escritores.add(nome);
	
	}
	
}
