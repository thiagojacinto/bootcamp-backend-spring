package com.service.ecommerce.DTO;

public class ItensVendaDTO {
	
	private Integer id;
	private Integer produtoID;
	private Integer quantidade;
	
	public ItensVendaDTO() {}

	/**
	 * @param produtoID
	 * @param vendaID
	 * @param valorUnitario
	 */
	public ItensVendaDTO(Integer produtoID, Double valorUnitario, Integer quantidade) {
		this.produtoID = produtoID;
		this.quantidade = quantidade;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
