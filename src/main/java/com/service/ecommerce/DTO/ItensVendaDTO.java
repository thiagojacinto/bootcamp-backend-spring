package com.service.ecommerce.DTO;

public class ItensVendaDTO {
	
	private Integer id;
	private Integer produtoID;
	private Integer vendaID;
	private Double valorUnitario;
	private Integer quantidade;
	
	public ItensVendaDTO() {}

	/**
	 * @param produtoID
	 * @param vendaID
	 * @param valorUnitario
	 */
	public ItensVendaDTO(Integer produtoID, Integer vendaID, Double valorUnitario, Integer quantidade) {
		this.produtoID = produtoID;
		this.vendaID = vendaID;
		this.valorUnitario = valorUnitario;
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
	 * @return the vendaID
	 */
	public Integer getVendaID() {
		return vendaID;
	}

	/**
	 * @param vendaID the vendaID to set
	 */
	public void setVendaID(Integer vendaID) {
		this.vendaID = vendaID;
	}

	/**
	 * @return the valorUnitario
	 */
	public Double getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
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
