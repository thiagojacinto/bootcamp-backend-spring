package com.service.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Produto {
	
	@Id
	@NotNull(groups = ValidationGroups.RegisterValidation.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max = 200)
	private String nome;
	private String descricao;
	@NotNull
	private Double precoUnitario;
	
	@Size(max = 20)
	private String unidade;
	
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Fornecedor fornecedor;
	@ManyToOne
	private Marca marca;
	
	@OneToMany(mappedBy = "produto", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<FAQ> faqs = new ArrayList<FAQ>();
	
	public Produto() {}

	/**
	 * @param nome
	 * @param descricao
	 * @param preco_unitario
	 */
	public Produto(String nome, String descricao, Double preco_unitario) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = preco_unitario;
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
	 * @return the preco_unitario
	 */
	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param preco_unitario the preco_unitario to set
	 */
	public void setPrecoUnitario(Double preco_unitario) {
		this.precoUnitario = preco_unitario;
	}

	/**
	 * @return the unidade
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * @return the marca
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	/**
	 * @return the faqs
	 */
	public List<FAQ> getFaqs() {
		return faqs;
	}

	/**
	 * @param faqs the faqs to set
	 */
	public void setFaqs(List<FAQ> faqs) {
		this.faqs = faqs;
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
		Produto other = (Produto) obj;
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
		builder.append("Produto [");
		if (id != null) {
			builder.append("id = ");
			builder.append(id);
			builder.append(", ");
		}
		if (nome != null) {
			builder.append("nome = ");
			builder.append(nome);
			builder.append(", ");
		}
		if (descricao != null) {
			builder.append("descricao = ");
			builder.append(descricao);
			builder.append(", ");
		}
		if (precoUnitario != null) {
			builder.append("precoUnitario = ");
			builder.append(precoUnitario);
			builder.append(", ");
		}
		if (unidade != null) {
			builder.append("unidade = ");
			builder.append(unidade);
			builder.append(", ");
		}
		if (categoria != null) {
			builder.append("categoria = ");
			builder.append(categoria);
			builder.append(", ");
		}
		if (fornecedor != null) {
			builder.append("fornecedor = ");
			builder.append(fornecedor);
			builder.append(", ");
		}
		if (marca != null) {
			builder.append("marca = ");
			builder.append(marca);
			builder.append(", ");
		}
		if (faqs != null) {
			builder.append("FAQ = ");
			builder.append(faqs);
		}
		builder.append("]");
		return builder.toString();
	}

	
	
}
