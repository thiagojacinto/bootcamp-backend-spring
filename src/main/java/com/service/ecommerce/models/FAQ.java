package com.service.ecommerce.models;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name = "faq")
public class FAQ {
	
	@Id
	@NotNull(groups = ValidationGroups.RegisterValidation.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private OffsetDateTime datahora;
	
	@NotNull
	private String texto;
	
	@NotNull
	@ManyToOne
	private Produto produto;
	
	public FAQ() {
		this.datahora = OffsetDateTime.now();
	}
	
	public FAQ(String texto) {
		this.datahora = OffsetDateTime.now();
		this.texto = texto;
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
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
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
		FAQ other = (FAQ) obj;
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
		builder.append("FAQ [");
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
		if (texto != null) {
			builder.append("texto = ");
			builder.append(texto);
			builder.append(", ");
		}
		if (produto != null) {
			builder.append("produto = ");
			builder.append(produto);
		}
		builder.append("]");
		return builder.toString();
	}
}
