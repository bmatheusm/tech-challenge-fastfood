package com.techchallenge.fastfood.adapters.driven.infra.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;
import com.techchallenge.fastfood.domain.repository.PedidoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPedidoRepository extends JpaRepository<PedidoEntity, Long>, PedidoRepository {

}
