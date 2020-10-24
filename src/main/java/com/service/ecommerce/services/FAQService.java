package com.service.ecommerce.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.FAQ;
import com.service.ecommerce.models.Produto;
import com.service.ecommerce.repositories.FAQRepository;
import com.service.ecommerce.repositories.ProdutoRepository;

@Service
public class FAQService implements ServicoBase<FAQRepository, FAQ>{

	@Autowired 
	private FAQRepository faqRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	/**
	 * Lista as FAQs a partir do Produto vinculado.
	 * @param produtoID {@code Integer}
	 * @return {@code List<FAQ>}
	 */
	public List<FAQ> listarPorProduto(Integer produtoID) {
		
		return faqRepository.findByProduto(produtoID);
	}

	@Override
	public Iterable<FAQ> listarTodos() {
		
		return faqRepository.findAll();
	}

	@Override
	public Optional<FAQ> exibirId(Integer idProcurada) {
		
		return faqRepository.findById(idProcurada);
	}

	@Override
	public FAQ cadastrar(FAQ novoItem) {
		
		Optional<Produto> produtoProcurado = produtoRepository.findById(novoItem.getProduto().getId());
		
		if (produtoProcurado.isEmpty()) {
			throw new DomainException("Produto inexistente. Verifique o ID do produto para registrar esta FAQ.");
		}
		
		novoItem.setDatahora(OffsetDateTime.now());
				
		return faqRepository.save(novoItem);
	}

	@Override
	public FAQ alterar(FAQ novoItem) {
		
		return faqRepository
				.findById(novoItem.getId())
				.map(faq -> {
					
					faq.setProduto(novoItem.getProduto());
					faq.setTexto(novoItem.getTexto());
					
					return faqRepository.save(faq);
				})
				.orElseThrow();
				
	}

	@Override
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Tente inserir novamente");
		}
		
		faqRepository.deleteById(peloId);
	}
	
}
