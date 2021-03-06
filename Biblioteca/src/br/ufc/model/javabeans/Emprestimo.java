package br.ufc.model.javabeans;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	public String idCliente;
	public String idFuncionario;
	public String idLivro;
	public Calendar dataEmprestimo;
	public Calendar dataDevolucao;
	public Calendar dataEntrega;
	public int renovacoes;
	private String nomeLivro;
	private double multa;
	/**
	 * @return the idCliente
	 */
	public String getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the idFuncionario
	 */
	public String getIdFuncionario() {
		return idFuncionario;
	}
	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
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
	 * @return the dataEmprestimo
	 */
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	/**
	 * @param dataEmprestimo the dataEmprestimo to set
	 */
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	/**
	 * @return the dataDevolucao
	 */
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	/**
	 * @param dataDevolucao the dataDevolucao to set
	 */
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	/**
	 * @return the dataEntrega
	 */
	public Calendar getDataEntrega() {
		return dataEntrega;
	}
	/**
	 * @param dataEntrega the dataEntrega to set
	 */
	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	/**
	 * @return the renovacoes
	 */
	public int getRenovacoes() {
		return renovacoes;
	}
	/**
	 * @param renovacoes the renovacoes to set
	 */
	public void setRenovacoes(int renovacoes) {
		this.renovacoes = renovacoes;
	}
	/**
	 * @return the nomeLivro
	 */
	public String getNomeLivro() {
		return nomeLivro;
	}
	/**
	 * @param nomeLivro the nomeLivro to set
	 */
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	public double getMulta(){
		return this.multa;
	}
	
	public void setMulta(){
		
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.setTime(new Date(System.currentTimeMillis()));
		
		if(dataDevolucao == null && dataAtual.after(dataEntrega)){
			dataAtual.set(Calendar.MILLISECOND, 0);
			dataEntrega.set(Calendar.MILLISECOND, 0);
			
			long atual = dataAtual.getTimeInMillis();
			long entrega = this.dataEntrega.getTimeInMillis();
			
			long diferenca = (atual - entrega)/(24 * 60 * 60 * 1000);
			
			this.multa = 0.5 * diferenca;
		}else{
			this.multa = 0.0;
		}
	}
}
