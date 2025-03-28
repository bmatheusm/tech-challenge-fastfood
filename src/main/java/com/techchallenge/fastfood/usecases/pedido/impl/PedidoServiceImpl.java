package com.techchallenge.fastfood.usecases.pedido.impl;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;
import com.techchallenge.fastfood.domain.entities.PedidoEntity;
import com.techchallenge.fastfood.domain.entities.ProdutoEntity;
import com.techchallenge.fastfood.domain.exception.BusinessException;
import com.techchallenge.fastfood.gateways.repository.ClienteGateway;
import com.techchallenge.fastfood.gateways.repository.PagamentoGateway;
import com.techchallenge.fastfood.gateways.repository.PedidoGateway;
import com.techchallenge.fastfood.gateways.repository.ProdutoGateway;
import com.techchallenge.fastfood.infrastructure.dto.PedidoDTO;
import com.techchallenge.fastfood.infrastructure.enums.ExceptionEnum;
import com.techchallenge.fastfood.infrastructure.enums.StatusPagamento;
import com.techchallenge.fastfood.infrastructure.enums.StatusPedido;
import com.techchallenge.fastfood.usecases.pedido.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoGateway pedidoGateway;

    @Autowired
    private ProdutoGateway produtoGateway;

    @Autowired
    private ClienteGateway clienteGateway;

    @Autowired
    private PagamentoGateway pagamentoGateway;


    @Override
    public List<PedidoEntity> listarTodos() {
        return this.pedidoGateway.findAllToDisplay();
    }

    @Override
    public Optional<PedidoEntity> checkoutPedido(PedidoDTO pedidoDTO) {
        if (pedidoDTO.getProdutosId().isEmpty()) throw new BusinessException(ExceptionEnum.PEDIDO_INVALIDO);
        return Optional.of(pedidoGateway.save(this.montaPedido(pedidoDTO)));
    }

    private PedidoEntity montaPedido(PedidoDTO pedidoDTO) {
        PedidoEntity pedido = new PedidoEntity();

        Optional<ClienteEntity> cliente = clienteGateway.findByCpf(pedidoDTO.getCpf());
        cliente.ifPresent(clienteEntity -> pedido.setCliente(clienteEntity));

        List<ProdutoEntity> produtos = produtoGateway.findAllByIdIn(pedidoDTO.getProdutosId());
        pedido.setProdutos(produtos);

        pedido.setStatusPedido(StatusPedido.RECEBIDO);
        pedido.setValorTotal(produtos.stream().map(ProdutoEntity::getPreco).reduce(0.0, Double::sum));

        return pedido;
    }

    @Override
    public Optional<PedidoEntity> alterarPedido(Long id, PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = this.pedidoGateway.findById(id).orElseThrow(IllegalArgumentException::new);

        if (this.isStatusPedidoAlteravel(pedidoDTO.getStatusPedido(), pedidoEntity)) {
            pedidoEntity.setStatusPedido(pedidoDTO.getStatusPedido());
        }

        List<ProdutoEntity> produtos = produtoGateway.findAllByIdIn(pedidoDTO.getProdutosId());
        pedidoEntity.setProdutos(produtos);

        pedidoEntity.setValorTotal(produtos.stream().map(ProdutoEntity::getPreco).reduce(0.0, Double::sum));

        return Optional.of(pedidoGateway.save(pedidoEntity));
    }

    @Override
    public Optional<PedidoEntity> definirProximaOperacao(Long id) {
        PedidoEntity pedidoEntity = this.pedidoGateway.findById(id).orElseThrow(IllegalArgumentException::new);
        StatusPedido proximaOperacao = pedidoEntity.getStatusPedido().getNext();

        boolean pagamentoAprovado = pagamentoGateway.existsByPedidoIdAndPagamentoStatusAprovado(pedidoEntity.getId());

        if (StatusPedido.EM_PREPARACAO.equals(proximaOperacao) && !pagamentoAprovado) {
            throw new BusinessException(ExceptionEnum.PAGAMENTO_PENDENTE, pedidoEntity.getId().toString());
        }

        pedidoEntity.setStatusPedido(proximaOperacao);

        return Optional.of(pedidoGateway.save(pedidoEntity));
    }

    private boolean isStatusPedidoAlteravel(StatusPedido novoStatusPedido, PedidoEntity pedidoEntity) {
        return novoStatusPedido != null &&
                pedidoEntity.getStatusPedido() != novoStatusPedido &&
                pedidoEntity.getPagamento() != null &&
                pedidoEntity.getPagamento().getStatus().equals(StatusPagamento.APROVADO);
    }
}
