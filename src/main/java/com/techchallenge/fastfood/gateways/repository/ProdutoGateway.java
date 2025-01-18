package com.techchallenge.fastfood.gateways.repository;

import com.techchallenge.fastfood.domain.entities.ProdutoEntity;
import com.techchallenge.fastfood.infrastructure.enums.CategoriaProduto;

import java.util.List;

public interface ProdutoGateway {

    List<ProdutoEntity> findAllByCategoria(CategoriaProduto categoriaProduto);

    List<ProdutoEntity> findAllByIdIn(List<Long> ids);

    ProdutoEntity save(ProdutoEntity produtoEntity);

    void deleteById(Long id);

}
