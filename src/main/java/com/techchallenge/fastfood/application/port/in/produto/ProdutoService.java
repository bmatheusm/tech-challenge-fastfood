package com.techchallenge.fastfood.application.port.in.produto;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.application.dto.ProdutoDTO;
import com.techchallenge.fastfood.domain.enums.CategoriaProduto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    List<ProdutoEntity> listarTodosDaCategoria(CategoriaProduto categoriaProduto);

    Optional<ProdutoEntity> cadastrarProduto(ProdutoDTO produtoDTO);

    Optional<ProdutoEntity> editarProduto(Long id, ProdutoDTO produtoDTO);

    void deletarProduto(Long id);
}
