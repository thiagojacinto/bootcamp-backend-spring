package com.service.ecommerce.exceptions.api;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DetalhesExcecao {

	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<TipoDeProblema> tipos;
	
	public static class TipoDeProblema {
		
		private String campo;
		private String mensagem;
		/**
		 * @param campo
		 * @param mensagem
		 */
		public TipoDeProblema(String campo, String mensagem) {
			super();
			this.campo = campo;
			this.mensagem = mensagem;
		}
		/**
		 * @return the campo
		 */
		public String getCampo() {
			return campo;
		}
		/**
		 * @param campo the campo to set
		 */
		public void setCampo(String campo) {
			this.campo = campo;
		}
		/**
		 * @return the mensagem
		 */
		public String getMensagem() {
			return mensagem;
		}
		/**
		 * @param mensagem the mensagem to set
		 */
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the dataHora
	 */
	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	/**
	 * @param dataHora the dataHora to set
	 */
	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the tipos
	 */
	public List<TipoDeProblema> getTipos() {
		return tipos;
	}

	/**
	 * @param tipos the tipos to set
	 */
	public void setTipos(List<TipoDeProblema> tipos) {
		this.tipos = tipos;
	}
	
}
