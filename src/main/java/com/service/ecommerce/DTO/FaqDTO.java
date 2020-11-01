package com.service.ecommerce.DTO;

public class FaqDTO {
	
	private String texto;
	private Integer produtoID;
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	/**
	 * @return the produtoID
	 */
	public Integer getProdutoID() {
		return produtoID;
	}
	/**
	 * @param produtoID the produtoID to set
	 */
	public void setProdutoID(Integer produtoID) {
		this.produtoID = produtoID;
	}
	
}
