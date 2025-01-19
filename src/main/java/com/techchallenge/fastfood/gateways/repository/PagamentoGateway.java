package com.techchallenge.fastfood.gateways.repository;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;

public interface PagamentoGateway {
    PagamentoEntity save(PagamentoEntity pagamento);

    boolean existsByPedidoIdAndPagamentoStatusAprovado(Long id);

    PagamentoEntity findByPedidoId(Long id);
}
