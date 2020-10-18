package com.service.ecommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.service.ecommerce.models.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	/**
	 * Busca por um cliente dado ID.
	 */
	Optional<Cliente> findById(Integer id);
	
	/**
	 * Busca por cliente dado um CPF como entrada.
	 * @param cpf como {@code String}
	 * @return {@code List<Cliente>}
	 */
	List<Cliente> findByCpf(String cpf);
	
	/**
	 * Busca por cliente dado um E-mail como entrada.
	 * @param email como {@code String}
	 * @return {@code List<Cliente>}
	 */
	List<Cliente> findByEmail(String email);
	
}