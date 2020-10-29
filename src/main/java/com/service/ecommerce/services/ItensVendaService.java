package com.service.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.service.ecommerce.DTO.ItensVendaDTO;
import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.ItensVenda;
import com.service.ecommerce.models.Produto;
import com.service.ecommerce.models.Venda;
import com.service.ecommerce.repositories.ItensVendaRepository;
import com.service.ecommerce.repositories.ProdutoRepository;
import com.service.ecommerce.repositories.VendaRepository;

@Service
public class ItensVendaService {
	
	@Autowired
	private ItensVendaRepository itens;
	@Autowired
	private ProdutoRepository produtos;
	@Autowired
	private VendaRepository vendas;
	
	/**
	 * Lista os Itens da Venda por Produto
	 * @param produtoID {@code Integer}
	 * @return {@code Page<ItensVenda>}
	 */
	public Page<ItensVenda> listarPorProduto(Integer produtoID) {
		
		if (produtoID == null) {
			throw new DomainException("ID de Produto inválido. Tente inserir novamente");
		}
		
		return itens.findByProduto_Id(produtoID, PageRequest.of(0, 10));
	}
	
	/**
	 * Lista os Itens da Venda por Venda
	 * @param vendaID {@code Integer}
	 * @return {@code Page<ItensVenda>}
	 */
	public Page<ItensVenda> listarPorVenda(Integer vendaID) {
		
		if (vendaID == null) {
			throw new DomainException("ID da Venda inválido. Tente inserir novamente");
		}
		
		return itens.findByVenda_Id(vendaID, PageRequest.of(0, 10));
	}
	
	/**
	 * Lista com Todos os Itens de Venda, paginados de 10 em 10.
	 * @return {@code Page<ItensVenda>} com 10 itens por página.
	 */
	public Iterable<ItensVenda> listarTodos() {
	
		return itens.findAll(PageRequest.of(0, 10));
	}

	
	public Optional<ItensVenda> exibirId(Integer idProcurada) {
		
		if (idProcurada == null) {
			throw new DomainException("ID inválido. Tente inserir novamente");
		}
		
		return itens.findById(idProcurada);
	}

	
	public ItensVenda cadastrar(ItensVendaDTO dto) {
		
		ItensVenda novoItem = this.converterItensDTOParaEntidade(dto);
		
		novoItem.setId(dto.getId());
		
		return itens.save(novoItem);
	}

	
	public ItensVenda alterar(ItensVendaDTO dto) {
		
		return itens
				.findById(dto.getId())
				.map((item) -> {
					
					ItensVenda itemConvertido = this.converterItensDTOParaEntidade(dto);
					
					item.setProduto(itemConvertido.getProduto());
					item.setValorUnitario(itemConvertido.getValorUnitario());
					item.setVenda(itemConvertido.getVenda());
					
					return itens.save(item);
				})
				.orElseThrow();
	}

	
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Tente inserir novamente");
		}
		
		itens.deleteById(peloId);
		
	}
	
	private ItensVenda validarRelacionamentos(ItensVendaDTO dto) {
		
		Optional<Produto> produtoProcurado = 
				produtos.findById(dto.getProdutoID());
		
		if (produtoProcurado.isEmpty()) {
			throw new DomainException("Produto inexistente. Verifique o ID do Produto para registrar este Item.");
		}
		
		Optional<Venda> vendaProcurada = 
				vendas.findById(dto.getVendaID());
		
		if (vendaProcurada.isEmpty()) {
			throw new DomainException("Venda inexistente. Verifique o ID da Venda para registrar este Item.");
		}
		
		ItensVenda itensVenda = new ItensVenda();
		itensVenda.setProduto(produtoProcurado.get());
		itensVenda.setVenda(vendaProcurada.get());
		
		return itensVenda;
		
	}
	
	private ItensVenda converterItensDTOParaEntidade(ItensVendaDTO dto) {
		
		ItensVenda itensVenda = this.validarRelacionamentos(dto);
		
		itensVenda.setValorUnitario(dto.getValorUnitario());
		
		return itensVenda;
	}

}
