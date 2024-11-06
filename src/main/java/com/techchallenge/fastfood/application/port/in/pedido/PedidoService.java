package com.techchallenge.fastfood.application.port.in.pedido;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;
import com.techchallenge.fastfood.application.dto.PedidoDTO;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<PedidoEntity> listarTodos();

    Optional<PedidoEntity> cadastrarPedido(PedidoDTO pedidoDTO);

    Optional<PedidoEntity> alterarPedido(Long id, PedidoDTO pedidoDTO);

    PedidoEntity finalizarPedido(Long id);

}
