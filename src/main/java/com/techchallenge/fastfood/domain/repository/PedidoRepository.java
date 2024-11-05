package com.techchallenge.fastfood.domain.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;

import java.util.List;

public interface PedidoRepository {

    List<PedidoEntity> findAll();

}
