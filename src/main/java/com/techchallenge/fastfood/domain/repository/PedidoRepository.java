package com.techchallenge.fastfood.domain.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    List<PedidoEntity> findAll();

    Optional<PedidoEntity> findById(Long id);

    PedidoEntity save(PedidoEntity pedidoEntity);

}
