package com.service.ecommerce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class FormaPagamento {
	
	@Id
	@NotNull(groups = ValidationGroups.RegisterValidation.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank 
	@Size(max = 200)
	private String forma;
	
	private String descricao;
	
	@NotNull
	private boolean ativo = true;
	
	public FormaPagamento() {}

	/**
	 * @param forma
	 * @param descricao
	 * @param ativo
	 */
	public FormaPagamento(String forma, String descricao, boolean ativo) {

		this.forma = forma;
		this.descricao = descricao;
		this.ativo = ativo;
	}

	/**
	 * @param forma
	 * @param ativo
	 */
	public FormaPagamento(String forma, boolean ativo) {
		this.forma = forma;
		this.ativo = ativo;
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
	 * @return the forma
	 */
	public String getForma() {
		return forma;
	}

	/**
	 * @param forma the forma to set
	 */
	public void setForma(String forma) {
		this.forma = forma;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
		FormaPagamento other = (FormaPagamento) obj;
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
		builder.append("FormaPagamento [");
		if (id != null) {
			builder.append("id = ");
			builder.append(id);
			builder.append(", ");
		}
		if (forma != null) {
			builder.append("forma = ");
			builder.append(forma);
			builder.append(", ");
		}
		if (descricao != null) {
			builder.append("descricao = ");
			builder.append(descricao);
			builder.append(", ");
		}
		builder.append("ativo = ");
		builder.append(ativo);
		builder.append("]");
		return builder.toString();
	}
	
}
