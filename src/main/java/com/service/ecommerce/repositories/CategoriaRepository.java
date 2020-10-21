package com.service.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.service.ecommerce.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
	
	/**
	 * Busca por uma categoria a partir do seu nome.
	 * @param nome como {@code String}
	 * @return {@code List<Categoria>}
	 */
	public List<Categoria> findByNome(String nome);
}
