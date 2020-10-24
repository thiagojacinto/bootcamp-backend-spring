package com.service.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.service.ecommerce.DTO.ProdutoDTO;
import com.service.ecommerce.models.Produto;
import com.service.ecommerce.services.ProdutoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(path = "/preco/{ordem}")
	@ApiOperation(value = "Lista os Produtos paginando e ordenando por preço unitário.")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Produto> listarProdutoPorPreco(
			@Valid @NotNull Integer pagina, 
			@Valid @NotNull Integer itens, 
			@ApiParam(value = "Ordenação, \"cresc\" para ordem crescente e \"dec\" ", example = "cresc", required = true, defaultValue = "dec")
			@PathVariable
			@NotBlank String ordem) {
		
		return produtoService.listarOrdenandoPorPreco(pagina, itens, ordem);
	}
	
	@GetMapping(path = "/{filtro}/{id}")
	@ApiOperation(value = "Lista os Produtos paginando e filtrando por Categoria, Marca ou Fornecedor")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Produto> filtrarProdutos(
			@Valid @NotNull Integer pagina, 
			@Valid @NotNull Integer itens,
			@ApiParam(value = "Tipo de filtro: \"Categoria\", \"Fornecedor\"  ou \"Marca\".", example = "Marca", required = true, defaultValue = "Categoria")
			@PathVariable @Valid @NotBlank 
			String filtro,
			@ApiParam(value = "ID do filtro", example = "1", required = true, defaultValue = "1")
			@PathVariable @NotNull 
			Integer id) {
		
		return produtoService.listaFiltrada(pagina, itens, filtro, id);
	}
	
	@GetMapping
	@ApiOperation(value = "Lista todos os Produtos")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Produto> listarProdutos() {
		
		return produtoService.listarTodos();
	}
	
	@GetMapping(path = "/{produtoID}")
	@ApiOperation(value = "Retorna um Produto com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Produto> exibirPorId(
			@ApiParam(value = "ID de um Produto.", example = "1", required = true)
			@PathVariable Integer produtoID) {
		
		return produtoService.exibirId(produtoID);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra um novo Produto")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto adicionarNovoProduto(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de um Produto", required = true)
			ProdutoDTO novoProduto) {
		
		return produtoService.cadastrar(novoProduto);
	}
	
	@DeleteMapping(path = "/{produtoID}")
	@ApiOperation(value = "Remove um Produto com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de um Produto.", example = "1", required = true)
			@PathVariable Integer produtoID) {
		
		produtoService.remover(produtoID);
	}
	
	@PutMapping(path = "/{produtoID}")
	@ApiOperation(value = "Altera os dados de um Produto a partir do seu ID")
	@ResponseStatus(code = HttpStatus.OK)
	public Produto alterar(
			@PathVariable 
			@ApiParam(value = "ID de um Produto registrado.", example = "1", required = true)
			Integer produtoID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de um Produto", required = true)
			ProdutoDTO produtoAlterado) {
		
		produtoAlterado.setId(produtoID);
		
		return produtoService.alterar(produtoAlterado);
	}
}
