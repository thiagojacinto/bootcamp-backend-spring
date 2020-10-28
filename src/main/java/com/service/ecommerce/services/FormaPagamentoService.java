package com.service.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.FormaPagamento;
import com.service.ecommerce.repositories.FormaPagamentoRepository;

@Service
public class FormaPagamentoService implements ServicoBase<FormaPagamentoRepository, FormaPagamento>{

	@Autowired
	private FormaPagamentoRepository formas;
		
	@Override
	public Iterable<FormaPagamento> listarTodos() {
		
		return formas.findAll();
	}

	@Override
	public Optional<FormaPagamento> exibirId(Integer idProcurada) {
		
		if (idProcurada == null) {
			throw new DomainException("ID inválido. Verifique o ID e tente novamente.");
		}
		
		return formas.findById(idProcurada);
	}

	@Override
	public FormaPagamento cadastrar(FormaPagamento novoItem) {
		
		List<FormaPagamento> formaHomonima = formas.findByForma(
				novoItem.getForma()
				);
		
		if (formaHomonima.size() > 0) {
			throw new DomainException("Forma já registrada: " + novoItem.getForma());
		}
		
		return formas.save(novoItem);
	}

	@Override
	public FormaPagamento alterar(FormaPagamento novoItem) {
		
		return formas
				.findById(novoItem.getId())
				.map(forma -> {
					
					forma.setAtivo(novoItem.isAtivo());
					forma.setDescricao(novoItem.getDescricao());
					forma.setForma(novoItem.getForma());
					
					return this.cadastrar(forma);
				})
				.orElseThrow();
	}

	@Override
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Verifique o ID e tente novamente.");
		}
		
		formas.deleteById(peloId);
	}
	
}
