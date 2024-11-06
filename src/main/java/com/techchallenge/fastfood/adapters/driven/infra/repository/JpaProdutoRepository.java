package com.techchallenge.fastfood.adapters.driven.infra.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.domain.repository.ProdutoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProdutoRepository extends JpaRepository<ProdutoEntity, Long>, ProdutoRepository {

}
