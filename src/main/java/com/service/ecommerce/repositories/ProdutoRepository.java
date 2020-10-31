package com.service.ecommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ecommerce.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	/**
	 * Lista de produtos ordenada pelo Preço Unitário. Usa {@code Pageable} e {@code Sort}
	 * @param pageable
	 * @return
	 */
	Page<Produto> findByOrderByPrecoUnitarioAsc(Pageable pageable);
	
	/**
	 * Lista de produtos por fornecedor, ordenado por fornecedor. Usa {@code Pageable}
	 * @param fornecedorID
	 * @return
	 */
	Page<Produto> findByFornecedor_IdOrderByFornecedor(Integer fornecedorID, Pageable pageable);
	
	/**
	 * Lista de produtos por categoria, ordenado por categoria. Usa {@code Pageable}
	 * @param categoriaID
	 * @return
	 */
	Page<Produto> findByCategoria_IdOrderByCategoria(Integer categoriaID, Pageable pageable);
	
	/**
	 *  Lista de produtos por marca, ordenado por marca. Usa {@code Pageable}
	 * @param marcaID
	 * @return
	 */
	Page<Produto> findByMarca_IdOrderByMarca(Integer marcaID, Pageable pageable);
}
