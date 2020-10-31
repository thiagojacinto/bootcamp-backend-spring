package com.service.ecommerce.controllers;

import java.util.List;
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

import com.service.ecommerce.DTO.FaqDTO;
import com.service.ecommerce.models.FAQ;
import com.service.ecommerce.services.FAQService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/faq")
public class FAQController {
	
	@Autowired
	private FAQService faqService;
	
	@GetMapping(path = "/produto/{produtoID}")
	@ApiOperation(value = "Lista as FAQs vinculadas por produto")
	@ResponseStatus(code = HttpStatus.OK)
	public List<FAQ> listarFAQPorProduto(
			@ApiParam(value = "ID de um Produto.", example = "1", required = true)
			@PathVariable Integer produtoID) {
		
		return faqService.listarPorProduto(produtoID);
	}
	
	@GetMapping
	@ApiOperation(value = "Lista todas as FAQs")
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<FAQ> listarFAQ() {
		
		return faqService.listarTodos();
	}
	
	@GetMapping(path = "/{faqID}")
	@ApiOperation(value = "Retorna uma FAQ com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<FAQ> exibirPorId(
			@ApiParam(value = "ID de um FAQ.", example = "1", required = true)
			@PathVariable Integer faqID) {
		
		return faqService.exibirId(faqID);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra um novo FAQ")
	@ResponseStatus(code = HttpStatus.CREATED)
	public FAQ adicionarNovaFAQ(
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma FAQ", required = true)
			FaqDTO novaFAQ) {
		
		return faqService.cadastrarViaDTO(novaFAQ);
	}
	
	@DeleteMapping(path = "/{faqID}")
	@ApiOperation(value = "Remove uma FAQ com ID correspondente")
	@ResponseStatus(code = HttpStatus.OK)
	public void remover(
			@ApiParam(value = "ID de uma FAQ.", example = "1", required = true)
			@PathVariable Integer faqID) {
		
		faqService.remover(faqID);
	}
	
	@PutMapping(path = "/{faqID}")
	@ApiOperation(value = "Altera os dados de uma FAQ a partir do seu ID")
	@ResponseStatus(code = HttpStatus.OK)
	public FAQ alterar(
			@PathVariable 
			@ApiParam(value = "ID de uma FAQ.", example = "1", required = true)
			Integer faqID,
			@Valid @RequestBody 
			@ApiParam(value = "JSON de uma FAQ", required = true)
			FaqDTO faqAlterada) {
		
		return faqService.alterarViaDTO(faqAlterada, faqID);
	}

}
