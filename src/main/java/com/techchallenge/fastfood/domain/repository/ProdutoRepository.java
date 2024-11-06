package com.techchallenge.fastfood.domain.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.domain.enums.CategoriaProduto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository {

    List<ProdutoEntity> findAllByCategoria(CategoriaProduto categoriaProduto);

    List<ProdutoEntity> findAllById(List<Long> ids);

    Optional<ProdutoEntity> save(ProdutoEntity produtoDTO);

    void deleteById(Long id);

}
