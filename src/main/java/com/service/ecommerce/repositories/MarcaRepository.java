package com.service.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.service.ecommerce.models.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
	
	/**
	 * Busca por uma marca a partir do seu nome.
	 * @param nome como {@code String}
	 * @return {@code List<Marca>}
	 */
	public List<Marca> findByNome(String nome);
	
}
