package com.techchallenge.fastfood.domain.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.domain.enums.CategoriaProduto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    List<ProdutoEntity> findAllByCategoria(CategoriaProduto categoriaProduto);

    List<ProdutoEntity> findAllByIdIn(List<Long> ids);

    ProdutoEntity save(ProdutoEntity produtoEntity);

    void deleteById(Long id);

}
