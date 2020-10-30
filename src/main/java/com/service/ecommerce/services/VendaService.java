package com.service.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.ecommerce.DTO.VendaDTO;
import com.service.ecommerce.exceptions.DomainException;
import com.service.ecommerce.models.Cliente;
import com.service.ecommerce.models.FormaPagamento;
import com.service.ecommerce.models.ItensVenda;
import com.service.ecommerce.models.Venda;
import com.service.ecommerce.repositories.ClienteRepository;
import com.service.ecommerce.repositories.FormaPagamentoRepository;
import com.service.ecommerce.repositories.ItensVendaRepository;
import com.service.ecommerce.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendas;
	@Autowired
	private ItensVendaRepository itens;
	@Autowired
	private FormaPagamentoRepository formas;
	@Autowired
	private ClienteRepository clientes;
	
	/**
	 * Lista Vendas a partir do ID de um Cliente, ordenada decrescentemente por Datahora.
	 * @param clienteID
	 * @param pagina, quantidade de páginas
	 * @param itensPorPagina, quantidade de items por página
	 * @return {@code List<Venda>}
	 */
	public List<Venda> listarPorClienteOrdenadoPorData(Integer clienteID, Integer pagina, Integer itensPorPagina) {
		
		Cliente clienteValidado = validarCliente(clienteID);
		
		Pageable paginacao = PageRequest.of(pagina, itensPorPagina);
		
		return vendas.findByCliente_IdOrderByDatahoraDesc(clienteValidado.getId(), paginacao);
	}
	
	/**
	 * Lista de Vendas por um cliente ordenado pelo ValorTotal de forma decrescente.
	 * @param clienteID
	 * @param pagina, quantidade de páginas
	 * @param itensPorPagina, quantidade de items por página
	 * @return {@code List<Venda>}
	 */
	public List<Venda> listarPorClienteOrdenandoPorValor(Integer clienteID, Integer pagina, Integer itensPorPagina) {
		
		Pageable paginacao = PageRequest.of(pagina, itensPorPagina);
		
		return vendas.findByCliente_IdOrderByValorTotalDesc(clienteID, paginacao);
	}
	
	/**
	 * Lista de Vendas por Forma de Pagamento.
	 * @param formaPagamentoID {@code Integer}
	 * @return {@code List<Venda>}
	 */
	public List<Venda> listarPorFormaDePagamento(Integer formaPagamentoID) {
		
		if (formaPagamentoID == null) {
			throw new DomainException("ID inválido. Verifique o ID e tente novamente.");
		}
		
		return vendas.findByFormaPagamento_Id(formaPagamentoID);
		
	}
	
	public Iterable<Venda> listarTodos() {
		
		return vendas.findAll();
	}
	
	public Optional<Venda> exibirId(Integer idProcurada) {
		
		if (idProcurada == null) {
			throw new DomainException("ID inválido. Verifique o ID e tente novamente.");
		}
		
		return vendas.findById(idProcurada);

	}

	
	public Venda cadastrar(VendaDTO vendaDTO) {
		
		Venda vendaConvertida = converterDTOparaVenda(vendaDTO);
		
		return vendas.save(vendaConvertida);
	}

	
	public Venda alterar(VendaDTO vendaDTO) {
		
		Venda vendaConvertida = converterDTOparaVenda(vendaDTO);

		return vendas
				.findById(vendaDTO.getId())
				.map(venda -> {
					
					if (vendaConvertida.getCliente() != null) venda.setCliente(vendaConvertida.getCliente());
					if (vendaConvertida.getFormaPagamento() != null) venda.setFormaPagamento(vendaConvertida.getFormaPagamento());
					if (vendaConvertida.getValorTotal() != null) venda.setValorTotal(vendaConvertida.getValorTotal());
					
					return vendas.save(venda);
				})
				.orElseThrow();
	}

	
	public void remover(Integer peloId) {
		
		if (peloId == null) {
			throw new DomainException("ID inválido. Verifique o ID e tente novamente.");
		}
		
		vendas.deleteById(peloId);
	}
	
	/**
	 * Valida os relacionamentos de Venda com outras entidades.
	 * @param dto, {@code VendaDTO}
	 * @return {@code Venda}
	 */
	private Venda validarRelacionamentosVenda(VendaDTO dto) {
		
		Optional<FormaPagamento> formaPagamentoProcurada = 
				formas.findById(dto.getFormaPagamentoID());
		
		if (formaPagamentoProcurada.isEmpty()) {
			throw new DomainException("Forma de Pagamento inexistente. Verifique o ID desta Forma de Pagamento para registrar a venda corretamente.");
		}
		
		Optional<Cliente> clienteProcurado = 
				clientes.findById(dto.getClienteID());
		
		if (clienteProcurado.isEmpty()) {
			throw new DomainException("Cliente inexistente. Verifique o ID deste Cliente para registrar a venda corretamente.");
		}
		
		List<ItensVenda> listaDeItensProcurada = new ArrayList<ItensVenda>();
		
		for (Integer itemID : dto.getItems()) {
			Optional<ItensVenda> itemProcurado =
					itens.findById(itemID);
			
			if (itemProcurado.isEmpty()) {
				throw new DomainException("Item de Venda inexistente. Verifique o ID deste Item de Venda para registrar a venda corretamente.");
			}
			
			listaDeItensProcurada.add(itemProcurado.get());
		}
		
		Venda venda = new Venda();
		venda.setItens(listaDeItensProcurada);
		venda.setCliente(clienteProcurado.get());
		venda.setFormaPagamento(formaPagamentoProcurada.get());
		return venda;
	}
	
	/**
	 * Converte de DTO para a entidade Venda.
	 * @param dto, {@code VendaDTO}
	 * @return {@code Venda}
	 */
	private Venda converterDTOparaVenda(VendaDTO dto) {
		
		Venda venda = validarRelacionamentosVenda(dto);
		
		venda.setValorTotal(1d);
		
		return venda;
	}
	
	/**
	 * Faz a validação do cliente informado a partir do seu ID.
	 * @param clienteID
	 * @return Cliente
	 */
	private Cliente validarCliente(Integer clienteID) {
		
		Optional<Cliente> clienteProcurado = 
				clientes.findById(clienteID);
		
		if (clienteProcurado.isEmpty()) {
			throw new DomainException("Cliente inexistente. Verifique o ID deste Cliente para registrar a venda corretamente.");
		}
		
		return clienteProcurado.get();
	}
}
