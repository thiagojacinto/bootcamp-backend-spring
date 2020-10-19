package com.service.ecommerce.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.service.ecommerce.models.Cliente;
import com.service.ecommerce.services.ClienteService;

@Controller
@RequestMapping("/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	/**
	 * Adiciona novo cliente.
	 * @param novoCliente
	 * @return {@code Cliente} clienteCadastrado
	 */
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Cliente adicionarNovoCliente(@Valid @RequestBody Cliente novoCliente) {
			
		return clienteService.cadastrar(novoCliente);
	
	}
	
	/**
	 * Lista todos os clientes cadastrados.
	 * @return Lista de clientes
	 */
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Iterable<Cliente> listarClientes() {
		
		return clienteService.listarTodosClientes();
	}
	
	/**
	 * Exibe dados de um cliente registrado a partir de seu ID.
	 * @param clienteId
	 * @return Dados do cliente.
	 */
	@GetMapping(path = "/{clienteId}")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Optional<Cliente> exibir(
				@PathVariable Integer clienteId
			) {
		
		return clienteService.exibirId(clienteId);

	}
	
	/**
	 * Deleta o cliente cujo ID seja passado como {@code PathParam}.
	 * @param clienteId
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping(path = "/{clienteId}")
	public void remover(@PathVariable Integer clienteId) {
		
		clienteService.remover(clienteId);
	}
	
	/**
	 * Modifica dados de um cliente cadastrado.
	 * @param {@code Integer} clienteId
	 * @param {@code Cliente} clienteAlterado
	 * @return Cliente clienteModificado
	 */
	@PutMapping(path = "/{clienteId}")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Cliente alterar(
				@PathVariable Integer clienteId,
				@Valid @RequestBody Cliente clienteAlterado
			) {
		
		clienteAlterado.setId(clienteId);
		
		return clienteService.alterar(clienteAlterado);

	}
}
