package com.techchallenge.fastfood.application.port.in.pedido;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;

import java.util.List;

public interface PedidoService {

    List<PedidoEntity> listarTodos();

}
