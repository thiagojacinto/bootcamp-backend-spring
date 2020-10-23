package com.service.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.Fornecedor;
import com.service.ecommerce.repositories.FornecedorRepository;

@Service
public class FornecedorService implements ServicoBase<FornecedorRepository, Fornecedor>{
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Override
	public Iterable<Fornecedor> listarTodos() {
		
		return fornecedorRepository.findAll();
	}

	@Override
	public Optional<Fornecedor> exibirId(Integer idProcurada) {
		
		return fornecedorRepository.findById(idProcurada);
	}

	@Override
	public Fornecedor cadastrar(Fornecedor novoItem) {
		
		List<Fornecedor> mesmoCnpj = fornecedorRepository.findByCnpj(novoItem.getCnpj());
		
		if (mesmoCnpj.size() > 0) {
			throw new DomainException("CNPJ já cadastrado. Verifique, e tente novamente.");
		}
		
		return fornecedorRepository.save(novoItem);
	}

	@Override
	public Fornecedor alterar(Fornecedor novoItem) {
		
		return fornecedorRepository
				.findById(novoItem.getId())
				.map(fornecedor -> {
					
					fornecedor.setCnpj(novoItem.getCnpj());
					fornecedor.setEmail(novoItem.getEmail());
					fornecedor.setEndereco(novoItem.getEndereco());
					fornecedor.setNome(novoItem.getNome());
					fornecedor.setTelefone(novoItem.getTelefone());
					
					return fornecedorRepository.save(fornecedor);
					
				})
				.orElseThrow();
	}

	@Override
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Tente inserir novamente.");
		}
		
		fornecedorRepository.deleteById(peloId);
		
	}

}
