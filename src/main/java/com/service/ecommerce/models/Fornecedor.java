package com.service.ecommerce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Fornecedor {
	
	@Id
	@NotNull(groups = ValidationGroups.RegisterValidation.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max = 200)
	private String nome;
	
	private String endereco;
	
	@Size(max = 20)
	private String telefone;
	
	@NotBlank
	@Size(max = 14)
	private String cnpj;
	
	@Size(max = 200)
	private String email;
	
	public Fornecedor() {}

	/**
	 * @param id
	 * @param nome
	 * @param endereco
	 * @param telefone
	 * @param cpnj
	 * @param email
	 */
	public Fornecedor(String nome,String endereco,
			String telefone, String cpnj,
			String email) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cnpj = cpnj;
		this.email = email;
	}
	
	public Fornecedor(String nome, String cnpj
			) {
		this.nome = nome;
		this.cnpj = cnpj;
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
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
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
		builder.append("Fornecedor [");
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
		if (endereco != null) {
			builder.append("endereco=");
			builder.append(endereco);
			builder.append(", ");
		}
		if (telefone != null) {
			builder.append("telefone=");
			builder.append(telefone);
			builder.append(", ");
		}
		if (cnpj != null) {
			builder.append("cnpj=");
			builder.append(cnpj);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
