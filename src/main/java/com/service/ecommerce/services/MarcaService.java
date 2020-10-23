package com.service.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.Marca;
import com.service.ecommerce.repositories.MarcaRepository;

@Service
public class MarcaService implements ServicoBase<MarcaRepository, Marca> {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Override
	public Iterable<Marca> listarTodos() {
		
		return marcaRepository.findAll();
	}

	@Override
	public Optional<Marca> exibirId(Integer idProcurada) {
		
		return marcaRepository.findById(idProcurada);
	}

	@Override
	public Marca cadastrar(Marca novoItem) {
		
		List<Marca> marcaHomonimas = marcaRepository.findByNome(novoItem.getNome());
		
		if (marcaHomonimas.size() > 0) {
			throw new DomainException("Marca já registrada com nome: " + novoItem.getNome());
		}
		
		return marcaRepository.save(novoItem);
	}

	@Override
	public Marca alterar(Marca novoItem) {
	
		return marcaRepository
				.findById(novoItem.getId())
				.map(marca -> {
					
					marca.setDescricao(novoItem.getDescricao());
					marca.setNome(novoItem.getNome());
					
					return marcaRepository.save(novoItem);
					
				})
				.orElseThrow();
	}

	@Override
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Tente inserir novamente");
		}
		
		marcaRepository.deleteById(peloId);
	}

}
