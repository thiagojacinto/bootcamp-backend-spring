package com.service.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.Categoria;
import com.service.ecommerce.models.Fornecedor;
import com.service.ecommerce.models.Marca;
import com.service.ecommerce.models.Produto;
import com.service.ecommerce.repositories.CategoriaRepository;
import com.service.ecommerce.repositories.FornecedorRepository;
import com.service.ecommerce.repositories.MarcaRepository;
import com.service.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService implements ServicoBase<ProdutoRepository, Produto> {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	// TODO Métodos com Pageable & Sort
	
	@Override
	public Iterable<Produto> listarTodos() {
		
		return produtoRepository.findAll();
	}

	@Override
	public Optional<Produto> exibirId(Integer idProcurada) {
		
		return produtoRepository.findById(idProcurada);
	}

	@Override
	public Produto cadastrar(Produto novoItem) {
		
		Optional<Categoria> categoriaProcurada = 
				categoriaRepository.findById(novoItem.getCategoria().getId());
		
		if (categoriaProcurada.isEmpty()) {
			throw new DomainException("Categoria inexistente. Verifique o ID da categoria para registrar este produto.");
		}
		
		Optional<Marca> marcaProcurada = 
				marcaRepository.findById(novoItem.getMarca().getId());
		
		if (marcaProcurada.isEmpty()) {
			throw new DomainException("Marca inexistente. Verifique o ID da marca para registrar este produto.");
		}
		
		Optional<Fornecedor> fornecedorProcurado =
				fornecedorRepository.findById(novoItem.getFornecedor().getId());
		
		if (fornecedorProcurado.isEmpty()) {
			throw new DomainException("Fornecedor inexistente. Verifique o ID do fornecedor para registrar este produto.");
		}
		
		return produtoRepository.save(novoItem);
	}

	@Override
	public Produto alterar(Produto novoItem) {
		
		return produtoRepository
				.findById(novoItem.getId())
				.map(prod -> {
					
					prod.setCategoria(novoItem.getCategoria());
					prod.setDescricao(novoItem.getDescricao());
					prod.setFornecedor(novoItem.getFornecedor());
					prod.setMarca(novoItem.getMarca());
					prod.setNome(novoItem.getNome());
					prod.setPreco_unitario(novoItem.getPreco_unitario());
					prod.setUnidade(novoItem.getUnidade());
					
					return produtoRepository.save(prod);
				})
				.orElseThrow();
	}	

	@Override
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Tente inserir novamente");
		}
		
		produtoRepository.deleteById(peloId);
		
	}

}
