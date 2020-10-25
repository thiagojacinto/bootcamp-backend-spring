package com.service.ecommerce.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ecommerce.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
	
	/**
	 * Lista de Vendas por um cliente ordenado por Data de forma decrescente.
	 * @param clienteID
	 * @param pageable
	 * @return {@code List<Venda>}
	 */
	public List<Venda> findAllByClienteOrderByDatahoraDesc(Integer clienteID, Pageable pageable);
	
	/**
	 * Lista de Vendas por um cliente ordenado pelo ValorTotal de forma decrescente.
	 * @param clienteID
	 * @param pageable
	 * @return {@code List<Venda>}
	 */
	public List<Venda> findAllByClienteOrderByValorTotalDesc(Integer clienteID, Pageable pageable);
	
	/**
	 * Lista de Vendas a partir de uma forma de pagamento.
	 * @param formaPagamentoID
	 * @return {@code List<Venda>}
	 */
	public List<Venda> findAllByFormaPagamento(Integer formaPagamentoID);
}
