package com.service.ecommerce.controllers;

import java.util.List;
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

import com.service.ecommerce.DTO.VendaDTO;
import com.service.ecommerce.models.Venda;
import com.service.ecommerce.services.VendaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/vendas")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping(path = "/pordata")
	@ApiOperation(value = "Lista as Vendas de um determinado Cliente, a partir de seu ID, paginando e ordenando por Data.")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Venda> listarVendasPorData(
			@RequestParam @Valid @NotNull Integer pagina, 
			@RequestParam @Valid @NotNull Integer itens,
			@ApiParam(value = "ID do Cliente", example = "1", required = true)
			@RequestParam
			@NotNull Integer clienteID) {
		
		return vendaService.listarPorClienteOrdenadoPorData(clienteID, pagina, itens);
	}
	
	@GetMapping(path = "/porvalor")
	@ApiOperation(value = "Lista as Vendas de um determinado Cliente, a partir de seu ID, paginando e ordenando por Valor.")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Venda> listarVendasPorValor(
			@RequestParam @Valid @NotNull Integer pagina, 
			@RequestParam @Valid @NotNull Integer itens,
			@ApiParam(value = "ID do Cliente", example = "1", required = true)
			@RequestParam
			@NotNull Integer clienteID) {
		
		return vendaService.listarPorClienteOrdenandoPorValor(clienteID, pagina, itens);
	}
	
	@GetMapping(path = "/porpagto")
	@ApiOperation(value = "Lista todas as Vendas por Forma de Pagamento")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Venda> listarVendasPorFormaPagamento(
			@ApiParam(value = "ID da Forma de Pagamento", example = "1", required = true)
			@RequestParam @NotNull Integer formaPagamentoID) {
		
		return vendaService.listarPorFormaDePagamento(formaPagamentoID);
	}
		
	@GetMapping
	@ApiOperation(value = "Lista todas as Vendas")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Venda> listarFormasPagamento() {
		
		return vendaService.listarTodos();
	}
	
	@GetMapping(path = "/{vendaID}")
	@ApiOperation(value = "Retorna uma Venda com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Venda> exibirPorId(
			@ApiParam(value = "ID de uma Venda.", example = "1", required = true)
			@PathVariable Integer vendaID) {
		
		return vendaService.exibirId(vendaID);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra uma nova Venda")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Venda adicionarNovaVenda(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma Venda", required = true)
			VendaDTO vendaDTO) {
		
		return vendaService.cadastrar(vendaDTO);
	}
	
	@DeleteMapping(path = "/{vendaID}")
	@ApiOperation(value = "Remove uma Venda com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de uma Venda.", example = "1", required = true)
			@PathVariable Integer vendaID) {
		
		vendaService.remover(vendaID);
	}
	
	@PutMapping(path = "/{vendaID}")
	@ApiOperation(value = "Altera os dados de uma Venda com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Venda alterar(
			@PathVariable 
			@ApiParam(value = "ID de uma Venda.", example = "1", required = true)
			Integer vendaID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma Venda", required = true)
			VendaDTO dtoAlterado) {
		
		dtoAlterado.setId(vendaID);
		
		return vendaService.alterar(dtoAlterado);
	}

}
