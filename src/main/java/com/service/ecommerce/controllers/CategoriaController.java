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

import com.service.ecommerce.models.Categoria;
import com.service.ecommerce.services.CategoriaService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Categoria> listarCategorias() {
		return categoriaService.listarTodos();
	}
	
	@GetMapping(path = "/{categoriaID}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Categoria> exibirPorId(
			@ApiParam(value = "ID de uma categoria.", example = "1", required = true)
			@PathVariable Integer categoriaID) {
		
		return categoriaService.exibirId(categoriaID);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categoria adicionarNovaCategoria(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma categoria", example = "{ \"nome\": \"nome-da-categoria\", \"ativo\": \"true\" }", required = true)
			Categoria novaCategoria) {
		
		return categoriaService.cadastrar(novaCategoria);
	}
	
	@DeleteMapping(path = "/{categoriaID}")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de uma categoria.", example = "1", required = true)
			@PathVariable Integer categoriaID) {
		
		categoriaService.remover(categoriaID);
	}
	
	@PutMapping(path = "/{categoriaID}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria alterar(
			@PathVariable 
			@ApiParam(value = "ID de uma categoria.", example = "1", required = true)
			Integer categoriaID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma categoria", example = "{ \"nome\": \"nome-da-categoria\", \"ativo\": \"true\" }", required = true)
			Categoria categoriaAlterada) {
		
		categoriaAlterada.setId(categoriaID);
		
		return categoriaService.alterar(categoriaAlterada);
	}
	
}
