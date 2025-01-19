package com.techchallenge.fastfood.infrastructure.repository;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.infrastructure.enums.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {

    boolean existsByPedidoIdAndStatus(Long pedidoId, StatusPagamento status);

    PagamentoEntity findByPedidoId(Long id);

}
