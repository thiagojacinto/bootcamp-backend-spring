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

import com.service.ecommerce.models.Marca;
import com.service.ecommerce.services.MarcaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@GetMapping
	@ApiOperation(value = "Lista todas as marcas")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Marca> listarMarcas() {
		return marcaService.listarTodos();
	}
		
	@GetMapping(path = "/{marcaID}")
	@ApiOperation(value = "Retorna uma marca com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Marca> exibirPorId(
			@ApiParam(value = "ID de uma marca.", example = "1", required = true)
			@PathVariable Integer marcaID) {
		
		return marcaService.exibirId(marcaID);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra uma nova marca")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Marca adicionarNovaMarca(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma marca", example = "{ \"nome\": \"nome-da-marca\", \"descricao\": \"descricao-em-texto\" }", required = true)
			Marca novaMarca) {
		
		return marcaService.cadastrar(novaMarca);
	}
	
	@DeleteMapping(path = "/{marcaID}")
	@ApiOperation(value = "Remove uma marca com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de uma marca.", example = "1", required = true)
			@PathVariable Integer marcaID) {
		
		marcaService.remover(marcaID);
	}
	
	@PutMapping(path = "/{marcaID}")
	@ApiOperation(value = "Altera os dados de uma marca com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Marca alterar(
			@PathVariable 
			@ApiParam(value = "ID de uma marca.", example = "1", required = true)
			Integer marcaID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma marca", example = "{ \"nome\": \"nome-da-marca\", \"descricao\": \"descricao-em-texto\" }", required = true)
			Marca marcaAlterada) {
		
		marcaAlterada.setId(marcaID);
		
		return marcaService.alterar(marcaAlterada);
	}
	
}
