package com.service.ecommerce.services;

import java.util.Optional;

public interface ServicoBase<Repositorio, Entidade> {
	
	/**
	 * Retorna uma lista de <Entidade> registradas.
	 * @return Lista de categorias, {@code Iterable<T>}
	 */
	public Iterable<Entidade> listarTodos();
	
	/**
	 * Exibir dados de uma categoria cadastrada a partir do ID.
	 * @param {@code Integer} ID
	 * @return <Entidade> procurada
	 */
	public Optional<Entidade> exibirId(Integer idProcurada);
	
	/**
	 * Cadastra nova instância de <Entidade>
	 * @param novoItem <Entidade>
	 * @return Instância de <Entidade> registrada.
	 */
	public Entidade cadastrar(Entidade novoItem); 
	
	/**
	 * Altera os dados
	 * @param Instância de <Entidade> já registrada.
	 */
	public Entidade alterar(Entidade novoItem);
	
	/**
	 * Remove uma instância de <Entidade> da base a partir do ID.
	 * @param peloId {@code Integer}
	 */
	public void remover(Integer peloId);
}
