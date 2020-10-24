package com.service.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.service.ecommerce.DTO.ProdutoDTO;
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
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	// TODO Métodos com Pageable & Sort
	
	/**
	 * Listando os produtos por ordem de preço.
	 * @param pagina, quantidade de páginas
	 * @param itens, quantidade de items por página
	 * @param ordem, sendo "cresc" para ordem crescente; e "dec" para decrescente.
	 * @return {@code List<Produto>}
	 */
	public List<Produto> listarOrdenandoPorPreco(Integer pagina, Integer itens, String ordem) {
		
		Sort sorting = Sort.unsorted();
		
		if (ordem.equals("cresc")) {
			sorting = Sort.by("precoUnitario").ascending();
			
		} else if (ordem.equals("dec")) {
			sorting = Sort.by("precoUnitario").descending();
		}
		
		Pageable paginacao = PageRequest.of(pagina, itens, sorting);
		
		return produtoRepository.findByOrderByPrecoUnitario(paginacao);
	}
	
	/**
	 * Lista de produtos a partir do filtro entre: marca, fornecedor ou categoria.
	 * @param paginas
	 * @param itens
	 * @param filtro sendo "fornecedor", "marca" ou "categoria"
	 * @param id
	 * @return {@code List<Produto>}
	 */
	public List<Produto> listaFiltrada(Integer paginas, Integer itens, String filtro, Integer id) {
		
		Pageable paginacao = PageRequest.of(paginas, itens);
		
		switch (filtro) {
		
		case "fornecedor":
			
			return produtoRepository.findAllByFornecedorIgnoreCaseOrderByFornecedor(id, paginacao);

		case "categoria":
			
			return produtoRepository.findAllByCategoriaIgnoreCaseOrderByCategoria(id, paginacao);
			
		case "marca":
			
			return produtoRepository.findAllByMarcaIgnoreCaseOrderByMarca(id, paginacao);

		default:
			return null;
		}
		
	}
	
	
	public Iterable<Produto> listarTodos() {
		
		return produtoRepository.findAll();
	}

	
	public Optional<Produto> exibirId(Integer idProcurada) {
		
		return produtoRepository.findById(idProcurada);
	}

	
	public Produto cadastrar(ProdutoDTO novoItem) {
		
		Produto novoProduto = converterProdutoDTOParaEntidade(novoItem);
		
		return produtoRepository.save(novoProduto);
	}

	
	public Produto alterar(ProdutoDTO novoProdutoDTO) {
		
		Produto novoItem = converterProdutoDTOParaEntidade(novoProdutoDTO);
		
		return produtoRepository
				.findById(novoItem.getId())
				.map(prod -> {
					
					prod.setCategoria(novoItem.getCategoria());
					prod.setDescricao(novoItem.getDescricao());
					prod.setFornecedor(novoItem.getFornecedor());
					prod.setMarca(novoItem.getMarca());
					prod.setNome(novoItem.getNome());
					prod.setPrecoUnitario(novoItem.getPrecoUnitario());
					prod.setUnidade(novoItem.getUnidade());
					
					return produtoRepository.save(prod);
				})
				.orElseThrow();
	}	

	
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Tente inserir novamente");
		}
		
		produtoRepository.deleteById(peloId);
		
	}
	
	private Produto converterProdutoDTOParaEntidade(ProdutoDTO dto) {
		
		Produto produto = validarRelacionamentos(dto);
		
		produto.setDescricao(dto.getDescricao());
		produto.setNome(dto.getNome());
		produto.setPrecoUnitario(dto.getPrecoUnitario());
		produto.setUnidade(dto.getUnidade());
		
		return produto;
	}
	
	private Produto validarRelacionamentos(ProdutoDTO dto) {
		
		Optional<Categoria> categoriaProcurada = 
				categoriaRepository.findById(dto.getIdCategoria());
		
		if (categoriaProcurada.isEmpty()) {
			throw new DomainException("Categoria inexistente. Verifique o ID da categoria para registrar este produto.");
		}
		
		Optional<Marca> marcaProcurada = 
				marcaRepository.findById(dto.getIdMarca());
		
		if (marcaProcurada.isEmpty()) {
			throw new DomainException("Marca inexistente. Verifique o ID da marca para registrar este produto.");
		}
		
		Optional<Fornecedor> fornecedorProcurado =
				fornecedorRepository.findById(dto.getIdFornecedor());
		
		if (fornecedorProcurado.isEmpty()) {
			throw new DomainException("Fornecedor inexistente. Verifique o ID do fornecedor para registrar este produto.");
		}
		
		Produto novoProduto = new Produto();
		novoProduto.setCategoria(categoriaProcurada.get());
		novoProduto.setMarca(marcaProcurada.get());
		novoProduto.setCategoria(categoriaProcurada.get());
		return novoProduto;
	}

}
