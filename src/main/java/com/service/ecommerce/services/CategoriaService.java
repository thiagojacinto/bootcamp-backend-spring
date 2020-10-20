package com.service.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.Categoria;
import com.service.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService implements ServicoBase<CategoriaRepository, Categoria>{
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public Iterable<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> exibirId(Integer idProcurada) {
		return categoriaRepository.findById(idProcurada);
	}

	@Override
	public Categoria cadastrar(Categoria novoItem) {
		return categoriaRepository.save(novoItem);
	}

	@Override
	public Categoria alterar(Categoria novoItem) {
		return categoriaRepository
				.findById(novoItem.getId())
				.map(categoria -> {
					categoria.setAtivo(novoItem.isAtivo());
					categoria.setNome(novoItem.getNome());
					
					return categoriaRepository.save(categoria);
				})
				.orElseThrow();
	}

	@Override
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Tente inserir novamente.");
		}
		
		categoriaRepository.deleteById(peloId);
	}
	
}
