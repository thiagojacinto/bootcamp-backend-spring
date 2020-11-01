package com.service.ecommerce.DTO;

import java.util.ArrayList;
import java.util.List;

public class VendaDTO {
	
	private Integer id;
	private Integer clienteID;
	private Integer formaPagamentoID;
	private List<Integer> items = new ArrayList<Integer>();
	
	public VendaDTO() {}

	/**
	 * @param valorTotal
	 * @param clienteID
	 * @param formaPagamentoID
	 */
	public VendaDTO(Integer clienteID, Integer formaPagamentoID, Integer itemID) {
		this.items.add(itemID);
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

	/**
	 * @return the items
	 */
	public List<Integer> getItems() {
		return items;
	}

	/**
	 * @param itemsIDList the items to set
	 */
	public void setItems(List<Integer> items) {
		this.items = items;
	}
	
}
