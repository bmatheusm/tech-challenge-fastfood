package com.techchallenge.fastfood.domain.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PagamentoEntity;

public interface PagamentoRepository {
    PagamentoEntity save(PagamentoEntity pagamento);
}
