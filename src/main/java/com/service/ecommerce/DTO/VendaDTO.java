package com.service.ecommerce.DTO;

public class VendaDTO {
	
	private Integer id;
	private Double valorTotal;
	private Integer clienteID;
	private Integer formaPagamentoID;
	
	public VendaDTO() {}

	/**
	 * @param valorTotal
	 * @param clienteID
	 * @param formaPagamentoID
	 */
	public VendaDTO(Integer clienteID, Integer formaPagamentoID, Double valorTotal) {
		this.valorTotal = valorTotal;
		this.clienteID = clienteID;
		this.formaPagamentoID = formaPagamentoID;
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
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the clienteID
	 */
	public Integer getClienteID() {
		return clienteID;
	}

	/**
	 * @param clienteID the clienteID to set
	 */
	public void setClienteID(Integer clienteID) {
		this.clienteID = clienteID;
	}

	/**
	 * @return the formaPagamentoID
	 */
	public Integer getFormaPagamentoID() {
		return formaPagamentoID;
	}

	/**
	 * @param formaPagamentoID the formaPagamentoID to set
	 */
	public void setFormaPagamentoID(Integer formaPagamentoID) {
		this.formaPagamentoID = formaPagamentoID;
	}
	
}
