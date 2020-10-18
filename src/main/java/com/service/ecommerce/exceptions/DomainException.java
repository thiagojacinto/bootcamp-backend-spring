package com.service.ecommerce.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Exceção da camada de domínio da aplicação.
	 * @exception
	 * RuntimeException
	 */
	public DomainException(String mensagem) {
		super(mensagem);
	}

}
