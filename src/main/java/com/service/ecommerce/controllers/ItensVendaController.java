package com.service.ecommerce.controllers;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.service.ecommerce.DTO.ItensVendaDTO;
import com.service.ecommerce.models.ItensVenda;
import com.service.ecommerce.services.ItensVendaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/v1/items")
public class ItensVendaController {
	
	@Autowired
	private ItensVendaService itensService;
	
	@GetMapping(path = "/porproduto")
	@ApiOperation(value = "Lista os Itens de Venda por Produto, paginando de 10 em 10 itens.")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<ItensVenda> listarPorProduto(
			@NotNull
			@RequestParam
			Integer id) {
		
		return itensService.listarPorProduto(id);
	}
	
	@GetMapping(path = "/porvenda")
	@ApiOperation(value = "Lista os Itens de Venda por Venda, paginando de 10 em 10 itens.")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<ItensVenda> listarPorVenda(
			@NotNull
			@RequestParam
			Integer id) {
		
		return itensService.listarPorVenda(id);
	}
	
	@GetMapping
	@ApiOperation(value = "Lista todos os Itens de Venda")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<ItensVenda> listarItensVendas() {
		return itensService.listarTodos();
	}
		
	@GetMapping(path = "/{itemID}")
	@ApiOperation(value = "Retorna um Item de Venda com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<ItensVenda> exibirPorId(
			@ApiParam(value = "ID de um Item de Venda.", example = "1", required = true)
			@PathVariable Integer itemID) {
		
		return itensService.exibirId(itemID);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra uma novo Item de Venda")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItensVenda adicionarNovosItensVenda(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de um Item de Venda", required = true)
			ItensVendaDTO novosItensVenda) {
		
		return itensService.cadastrar(novosItensVenda);
	}
	
	@DeleteMapping(path = "/{itemID}")
	@ApiOperation(value = "Remove um Item de Venda com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de um Item de Venda.", example = "1", required = true)
			@PathVariable Integer itemID) {
		
		itensService.remover(itemID);
	}
	
	@PutMapping(path = "/{itemID}")
	@ApiOperation(value = "Altera os dados de um Item de Venda com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public ItensVenda alterar(
			@PathVariable 
			@ApiParam(value = "ID de um Item de Venda.", example = "1", required = true)
			Integer itemID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de um Item de Venda", example = "{ \"nome\": \"nome-da-marca\", \"descricao\": \"descricao-em-texto\" }", required = true)
			ItensVendaDTO itemAlterado) {
		
		itemAlterado.setId(itemID);
		
		return itensService.alterar(itemAlterado);
	}
}
