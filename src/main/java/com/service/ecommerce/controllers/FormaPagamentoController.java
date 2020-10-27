package com.service.ecommerce.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.service.ecommerce.models.FormaPagamento;
import com.service.ecommerce.services.FormaPagamentoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/pagamento")
public class FormaPagamentoController {
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
		
	@GetMapping
	@ApiOperation(value = "Lista todas as Formas de Pagamento")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<FormaPagamento> listarFormasPagamento() {
		
		return formaPagamentoService.listarTodos();
	}
	
	@GetMapping(path = "/{pagamentoID}")
	@ApiOperation(value = "Retorna uma forma de pagamento com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<FormaPagamento> exibirPorId(
			@ApiParam(value = "ID de uma forma de pagamento.", example = "1", required = true)
			@PathVariable Integer pagamentoID) {
		
		return formaPagamentoService.exibirId(pagamentoID);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra uma nova Forma de Pagamento")
	@ResponseStatus(code = HttpStatus.CREATED)
	public FormaPagamento adicionarNovaFormaPagamento(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma Forma de Pagamento", required = true)
			FormaPagamento formaPagamento) {
		
		return formaPagamentoService.cadastrar(formaPagamento);
	}
	
	@DeleteMapping(path = "/{pagamentoID}")
	@ApiOperation(value = "Remove uma Forma de Pagamento com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de uma forma de pagamento.", example = "1", required = true)
			@PathVariable Integer pagamentoID) {
		
		formaPagamentoService.remover(pagamentoID);
	}
	
	@PutMapping(path = "/{pagamentoID}")
	@ApiOperation(value = "Altera os dados de uma Forma de Pagamento com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public FormaPagamento alterar(
			@PathVariable 
			@ApiParam(value = "ID de uma Forma de Pagamento.", example = "1", required = true)
			Integer pagamentoID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma Forma de Pagamento", required = true)
			FormaPagamento pagamentoAlterado) {
		
		pagamentoAlterado.setId(pagamentoID);
		
		return formaPagamentoService.alterar(pagamentoAlterado);
	}
}
