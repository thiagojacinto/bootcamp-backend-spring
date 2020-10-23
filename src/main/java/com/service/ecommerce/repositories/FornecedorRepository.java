package com.service.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.service.ecommerce.models.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer> {
	
	/**
	 * Procura por fornecedores a partir do CNPJ.
	 * @param cnpj
	 * @return Lista de fornecedores, {@code List<Fornecedores>}
	 */
	public List<Fornecedor> findByCnpj(String cnpj);
}
