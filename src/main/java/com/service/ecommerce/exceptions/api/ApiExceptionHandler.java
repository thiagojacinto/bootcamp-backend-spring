package com.service.ecommerce.exceptions.api;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.exceptions.api.DetalhesExcecao.TipoDeProblema;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> responderDomainException(DomainException exception, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		var problema = new DetalhesExcecao();
		problema.setStatus(status.value());
		problema.setDataHora(OffsetDateTime.now());
		problema.setTitulo(exception.getMessage());
		
		return handleExceptionInternal(exception, problema, new HttpHeaders(), status, request);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var tipos = new ArrayList<DetalhesExcecao.TipoDeProblema>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			tipos.add(new TipoDeProblema(nome, mensagem));
		}
		
		status = HttpStatus.BAD_REQUEST;
		
		var problema = new DetalhesExcecao();
		problema.setTipos(tipos);
		problema.setStatus(status.value());
		problema.setTitulo("Um ou mais campos estão inválidos. "
				+ "Faça o preenchimento correto e tente novamente.");
		problema.setDataHora(OffsetDateTime.now());
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}

}
