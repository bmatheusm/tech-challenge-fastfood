package com.techchallenge.fastfood.usecases.pedido;

import com.techchallenge.fastfood.domain.entities.PedidoEntity;
import com.techchallenge.fastfood.infrastructure.dto.PedidoDTO;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<PedidoEntity> listarTodos();

    Optional<PedidoEntity> checkoutPedido(PedidoDTO pedidoDTO);

    Optional<PedidoEntity> alterarPedido(Long id, PedidoDTO pedidoDTO);

    Optional<PedidoEntity> definirProximaOperacao(Long id);

}
