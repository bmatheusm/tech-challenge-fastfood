package com.techchallenge.fastfood.application.usecase.pedido;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;
import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;
import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.application.dto.PedidoDTO;
import com.techchallenge.fastfood.application.port.in.pedido.PedidoService;
import com.techchallenge.fastfood.domain.enums.StatusPedido;
import com.techchallenge.fastfood.domain.repository.ClienteRepository;
import com.techchallenge.fastfood.domain.repository.PedidoRepository;
import com.techchallenge.fastfood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<PedidoEntity> listarTodos() {
        return this.pedidoRepository.findAll();
    }

    @Override
    public Optional<PedidoEntity> cadastrarPedido(PedidoDTO pedidoDTO) {
        return Optional.of(pedidoRepository.save(this.montaPedido(pedidoDTO)));
    }

    private PedidoEntity montaPedido(PedidoDTO pedidoDTO) {
        PedidoEntity pedido = new PedidoEntity();

        Optional<ClienteEntity> cliente = clienteRepository.findByCpf(pedidoDTO.getCpf());
        cliente.ifPresent(clienteEntity -> pedido.setCliente(clienteEntity));

        List<ProdutoEntity> produtos = produtoRepository.findAllByIdIn(pedidoDTO.getProdutosId());
        pedido.setProdutos(produtos);

        pedido.setStatusPedido(StatusPedido.RECEBIDO);
        pedido.setValorTotal(produtos.stream().map(ProdutoEntity::getPreco).reduce(0.0, Double::sum));

        return pedido;
    }

    @Override
    public Optional<PedidoEntity> alterarPedido(Long id, PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = this.pedidoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        pedidoEntity.setStatusPedido(pedidoDTO.getStatusPedido());

        List<ProdutoEntity> produtos = produtoRepository.findAllByIdIn(pedidoDTO.getProdutosId());
        pedidoEntity.setProdutos(produtos);

        pedidoEntity.setValorTotal(produtos.stream().map(ProdutoEntity::getPreco).reduce(0.0, Double::sum));

        return Optional.of(pedidoRepository.save(pedidoEntity));
    }

    @Override
    public PedidoEntity finalizarPedido(Long id) {
        return null;
    }
}
