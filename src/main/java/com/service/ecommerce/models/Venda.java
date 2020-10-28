package com.service.ecommerce.models;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Venda {

	@Id
	@NotNull(groups = ValidationGroups.RegisterValidation.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private OffsetDateTime datahora = OffsetDateTime.now();
	
	private Double valorTotal;
	
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	private FormaPagamento formaPagamento;
	
	public Venda() {}

	/**
	 * @param cliente
	 * @param formaPagamento
	 * @param valorTotal
	 */
	public Venda(Cliente cliente,
			 FormaPagamento formaPagamento, Double valorTotal) {
		this.datahora = OffsetDateTime.now();
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.formaPagamento = formaPagamento;
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
	 * @return the datahora
	 */
	public OffsetDateTime getDatahora() {
		return datahora;
	}

	/**
	 * @param datahora the datahora to set
	 */
	public void setDatahora(OffsetDateTime datahora) {
		this.datahora = datahora;
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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the formaPagamento
	 */
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * @param formaPagamento the formaPagamento to set
	 */
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Venda [");
		if (id != null) {
			builder.append("id = ");
			builder.append(id);
			builder.append(", ");
		}
		if (datahora != null) {
			builder.append("datahora = ");
			builder.append(datahora);
			builder.append(", ");
		}
		if (valorTotal != null) {
			builder.append("valorTotal = ");
			builder.append(valorTotal);
			builder.append(", ");
		}
		if (cliente != null) {
			builder.append("cliente = ");
			builder.append(cliente);
			builder.append(", ");
		}
		if (formaPagamento != null) {
			builder.append("formaPagamento = ");
			builder.append(formaPagamento);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
