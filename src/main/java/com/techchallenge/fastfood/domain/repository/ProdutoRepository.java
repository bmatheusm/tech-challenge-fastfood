package com.techchallenge.fastfood.domain.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.domain.enums.CategoriaProduto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository {

    List<ProdutoEntity> findAllByCategoria(CategoriaProduto categoriaProduto);

    Optional<ProdutoEntity> save(ProdutoEntity produtoDTO);

    void deleteById(Long id);

}
