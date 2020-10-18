package com.service.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.Cliente;
import com.service.ecommerce.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * Retorna uma lista {@code Iterable} de clientes cadastrados. 
	 * @return
	 */
	public Iterable<Cliente> listarTodosClientes() {
		
		return clienteRepository.findAll();
		
	}
	
	/**
	 * Cadastra novo cliente na base.
	 * @param novoCliente
	 * @return Cliente cadastrado
	 */
	public Cliente cadastrar(Cliente novoCliente) {
		
		List<Cliente> clienteEmailExistente = clienteRepository.findByEmail(novoCliente.getEmail());
		List<Cliente> clienteCPFExistente = clienteRepository.findByCpf(novoCliente.getCpf());
		
		if (clienteEmailExistente.size() > 0) {
			throw new DomainException("E-mail já existente. Tente recuperar sua conta.");
			
		} else if (clienteCPFExistente.size() > 0) {
			throw new DomainException("CPF já cadastrado. Tente recuperar sua conta.");
		}
		
		return clienteRepository.save(novoCliente);
	}
	
	/**
	 * Remove um cliente da base a partir do ID.
	 * @param id
	 */
	public void remover(Integer id) {
		
		if (id == null) {
			throw new DomainException("ID inválido. Tente inserir novamente.");
		}
		
		clienteRepository.deleteById(id);
	}
	
	/**
	 * Altera os dados de um cliente
	 * @param novosDadosCliente
	 */
	public Cliente alterar(Cliente novosDadosCliente) {

		return clienteRepository
				.findById(novosDadosCliente.getId())
				.map(cliente -> {
					cliente.setNome(novosDadosCliente.getNome());
					cliente.setNomeSocial(novosDadosCliente.getNomeSocial());
					cliente.setApelido(novosDadosCliente.getApelido());
					cliente.setDataNascimento(novosDadosCliente.getDataNascimento());
					cliente.setTelefone(novosDadosCliente.getTelefone());
					cliente.setSexo(novosDadosCliente.getSexo());
					cliente.setEmail(novosDadosCliente.getEmail());

					return clienteRepository.save(cliente);
				})
				.orElseThrow();
	}

	/**
	 * Exibir dados de um cliente cadastrado a partir do seu ID
	 * @param clienteId
	 * @return Cliente procurado
	 */
	public Optional<Cliente> exibirId(Integer clienteId) {
		return clienteRepository.findById(clienteId);
	}
}
