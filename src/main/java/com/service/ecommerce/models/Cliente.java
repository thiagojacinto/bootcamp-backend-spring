package com.service.ecommerce.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@NotNull(groups = ValidationGroups.CadastroClienteValidation.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max = 250)
	private String nome;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 11, max = 11)
	private String cpf;
	
	@Column(name = "Datanascimento")
	private Date dataNascimento;
	private String sexo;
	@Column(name = "Nomesocial")
	private String nomeSocial;
	private String apelido;
	private String telefone;

	protected Cliente() {}

	/**
	 * @param nome
	 * @param email
	 * @param cpf
	 * @param dataNascimento
	 * @param sexo
	 * @param nomeSocial
	 * @param apelido
	 * @param telefone
	 */
	public Cliente( String nome, String email, String cpf, Date dataNascimento, String sexo,
			String nomeSocial, String apelido, String telefone) {

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.nomeSocial = nomeSocial;
		this.apelido = apelido;
		this.telefone = telefone;
	}

	/**
	 * @param nome
	 * @param email
	 * @param cpf
	 */
	public Cliente(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
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
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the nomeSocial
	 */
	public String getNomeSocial() {
		return nomeSocial;
	}
	/**
	 * @param nomeSocial the nomeSocial to set
	 */
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	/**
	 * @return the apelido
	 */
	public String getApelido() {
		return apelido;
	}
	/**
	 * @param apelido the apelido to set
	 */
	public void setApelido(String apelido) {
		this.apelido = apelido;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [ ");
		if (id != null) {
			builder.append("id: ");
			builder.append(id);
			builder.append(", ");
		}
		if (nome != null) {
			builder.append("nome: ");
			builder.append(nome);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email: ");
			builder.append(email);
			builder.append(", ");
		}
		if (cpf != null) {
			builder.append("cpf: ");
			builder.append(cpf);
			builder.append(", ");
		}
		if (dataNascimento != null) {
			builder.append("dataNascimento: ");
			builder.append(dataNascimento);
			builder.append(", ");
		}
		if (sexo != null) {
			builder.append("sexo: ");
			builder.append(sexo);
			builder.append(", ");
		}
		if (nomeSocial != null) {
			builder.append("nomeSocial: ");
			builder.append(nomeSocial);
			builder.append(", ");
		}
		if (apelido != null) {
			builder.append("apelido: ");
			builder.append(apelido);
			builder.append(", ");
		}
		if (telefone != null) {
			builder.append("telefone: ");
			builder.append(telefone);
		}
		builder.append(" ]");
		return builder.toString();
	}
	
}
