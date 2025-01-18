package com.techchallenge.fastfood.gateways.repository;

import com.techchallenge.fastfood.domain.entities.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway {

    List<PedidoEntity> findAllToDisplay();

    Optional<PedidoEntity> findById(Long id);

    PedidoEntity save(PedidoEntity pedidoEntity);

}
