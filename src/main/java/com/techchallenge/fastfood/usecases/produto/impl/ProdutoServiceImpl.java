package com.techchallenge.fastfood.usecases.produto.impl;

import com.techchallenge.fastfood.domain.entities.ProdutoEntity;
import com.techchallenge.fastfood.infrastructure.dto.ProdutoDTO;
import com.techchallenge.fastfood.infrastructure.enums.CategoriaProduto;
import com.techchallenge.fastfood.gateways.repository.ProdutoGateway;
import com.techchallenge.fastfood.usecases.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoGateway produtoGateway;

    @Override
    public List<ProdutoEntity> listarTodosDaCategoria(CategoriaProduto categoriaProduto) {
        return this.produtoGateway.findAllByCategoria(categoriaProduto);
    }

    @Override
    public Optional<ProdutoEntity> cadastrarProduto(ProdutoDTO produtoDTO) {
        return Optional.of(this.produtoGateway.save(this.montaProduto(produtoDTO)));
    }

    @Override
    public Optional<ProdutoEntity> editarProduto(Long id, ProdutoDTO produtoDTO) {
        ProdutoEntity produto = this.montaProduto(produtoDTO);
        produto.setId(id);
        return Optional.of(this.produtoGateway.save(produto));
    }

    @Override
    public void deletarProduto(Long id) {
        this.produtoGateway.deleteById(id);
    }


    private ProdutoEntity montaProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produto = new ProdutoEntity();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setCategoria(produtoDTO.getCategoria());

        return produto;
    }

}
