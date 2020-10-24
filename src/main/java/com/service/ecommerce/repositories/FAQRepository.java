package com.service.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.service.ecommerce.models.FAQ;

public interface FAQRepository extends CrudRepository<FAQ, Integer> {
	
	/**
	 * Lista de FAQs a partir do ID do Produto relacionado.
	 * @param produtoId
	 * @return {@code List<FAQ>}
	 */
	public List<FAQ> findByProduto(Integer produtoId);
}
