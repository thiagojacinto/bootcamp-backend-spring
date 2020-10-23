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

import com.service.ecommerce.models.Fornecedor;
import com.service.ecommerce.services.FornecedorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
		
	@GetMapping
	@ApiOperation(value = "Lista todas os fornecedores")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Fornecedor> listarFornecedores() {
		
		return fornecedorService.listarTodos();
	}
	
	@GetMapping(path = "/{fornecedorID}")
	@ApiOperation(value = "Retorna uma fornecedor com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Fornecedor> exibirPorId(
			@ApiParam(value = "ID de um fornecedor.", example = "1", required = true)
			@PathVariable Integer fornecedorID) {
		
		return fornecedorService.exibirId(fornecedorID);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra um novo fornecedor")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Fornecedor adicionarNovoFornecedor(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de um fornecedor", example = "{\n"
					+ "    \"nome\": \"nome-do-fornecedor\",\n"
					+ "    \"email\": \"email@do.fornecedor\",\n"
					+ "    \"cnpj\": \"XXXXXXXXXXXXXX\",\n"
					+ "    \"endereco\": \"\",\n"
					+ "    \"telefone\": \"000000000\"\n"
					+ "}", required = true)
			Fornecedor novoFornecedor) {
		
		return fornecedorService.cadastrar(novoFornecedor);
	}
	
	@DeleteMapping(path = "/{fornecedorID}")
	@ApiOperation(value = "Remove um fornecedor com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de um fornecedor.", example = "1", required = true)
			@PathVariable Integer fornecedorID) {
		
		fornecedorService.remover(fornecedorID);
	}
	
	@PutMapping(path = "/{fornecedorID}")
	@ApiOperation(value = "Altera os dados de um fornecedor com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Fornecedor alterar(
			@PathVariable 
			@ApiParam(value = "ID de um fornecedor.", example = "1", required = true)
			Integer fornecedorID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de um fornecedor", example = "{\n"
					+ "    \"nome\": \"nome-do-fornecedor\",\n"
					+ "    \"email\": \"email@do.fornecedor\",\n"
					+ "    \"cnpj\": \"XXXXXXXXXXXXXX\",\n"
					+ "    \"endereco\": \"\",\n"
					+ "    \"telefone\": \"000000000\"\n"
					+ "}", required = true)
			Fornecedor fornecedorAlterado) {
		
		fornecedorAlterado.setId(fornecedorID);
		
		return fornecedorService.alterar(fornecedorAlterado);
	}
	
}
