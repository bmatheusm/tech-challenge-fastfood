package com.techchallenge.fastfood.infrastructure.repository;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
}
