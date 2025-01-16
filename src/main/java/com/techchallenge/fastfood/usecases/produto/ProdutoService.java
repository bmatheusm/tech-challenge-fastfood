package com.techchallenge.fastfood.usecases.produto;

import com.techchallenge.fastfood.domain.entities.ProdutoEntity;
import com.techchallenge.fastfood.infrastructure.dto.ProdutoDTO;
import com.techchallenge.fastfood.infrastructure.enums.CategoriaProduto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    List<ProdutoEntity> listarTodosDaCategoria(CategoriaProduto categoriaProduto);

    Optional<ProdutoEntity> cadastrarProduto(ProdutoDTO produtoDTO);

    Optional<ProdutoEntity> editarProduto(Long id, ProdutoDTO produtoDTO);

    void deletarProduto(Long id);
}
