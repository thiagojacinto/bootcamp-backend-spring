package com.service.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.service.ecommerce.models.FormaPagamento;

public interface FormaPagamentoRepository extends CrudRepository<FormaPagamento, Integer> {
	
	/**
	 * Busca por uma Forma de Pagamento registrada e retorna uma lista.
	 * @param forma
	 * @return {@code List<FormaPagamento>}
	 */
	public List<FormaPagamento> findByForma(String forma);
}
