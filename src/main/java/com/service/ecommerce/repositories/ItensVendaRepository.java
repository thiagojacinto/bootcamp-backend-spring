package com.service.ecommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ecommerce.models.ItensVenda;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Integer> {
	
	/**
	 * Lista os Itens da Venda por Produto
	 * @param produtoID {@code Integer}
	 * @param paginacao {@code Pageable}
	 * @return {@code Page<ItensVenda>}
	 */
	public Page<ItensVenda> findByProduto_Id(Integer produtoID, Pageable paginacao);
	
	/**
	 * Lista os Itens da Venda por Venda
	 * @param vendaID {@code Integer}
	 * @param paginacao {@code Pageable}
	 * @return {@code Page<ItensVenda>}
	 */
	public Page<ItensVenda> findByVenda_Id(Integer vendaID, Pageable paginacao);
}
