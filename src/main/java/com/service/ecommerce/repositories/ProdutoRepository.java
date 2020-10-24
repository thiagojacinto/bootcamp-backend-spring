package com.service.ecommerce.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ecommerce.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	/**
	 * Lista de produtos ordenada pelo Preço Unitário. Usa {@code Pageable} e {@code Sort}
	 * @param pageable
	 * @return
	 */
	List<Produto> findByOrderByPrecoUnitario(Pageable pageable);
	
	/**
	 * Lista de produtos por fornecedor, ordenado por fornecedor. Usa {@code Pageable}
	 * @param fornecedorID
	 * @return
	 */
	List<Produto> findAllByFornecedorIgnoreCaseOrderByFornecedor(Integer fornecedorID, Pageable pageable);
	
	/**
	 * Lista de produtos por categoria, ordenado por categoria. Usa {@code Pageable}
	 * @param categoriaID
	 * @return
	 */
	List<Produto> findAllByCategoriaIgnoreCaseOrderByCategoria(Integer categoriaID, Pageable pageable);
	
	/**
	 *  Lista de produtos por marca, ordenado por marca. Usa {@code Pageable}
	 * @param marcaID
	 * @return
	 */
	List<Produto> findAllByMarcaIgnoreCaseOrderByMarca(Integer marcaID, Pageable pageable);
}
