package com.techchallenge.fastfood.adapters.driven.infra.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PagamentoEntity;
import com.techchallenge.fastfood.domain.repository.PagamentoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPegamentoRepository extends JpaRepository<PagamentoEntity, Long>, PagamentoRepository {
}
