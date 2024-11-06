package com.techchallenge.fastfood.application.usecase.produto;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.application.dto.ProdutoDTO;
import com.techchallenge.fastfood.application.port.in.produto.ProdutoService;
import com.techchallenge.fastfood.domain.enums.CategoriaProduto;
import com.techchallenge.fastfood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoEntity> listarTodosDaCategoria(CategoriaProduto categoriaProduto) {
        return this.produtoRepository.findAllByCategoria(categoriaProduto);
    }

    @Override
    public Optional<ProdutoEntity> cadastrarProduto(ProdutoDTO produtoDTO) {
        return Optional.of(this.produtoRepository.save(this.montaProduto(produtoDTO)));
    }

    @Override
    public Optional<ProdutoEntity> editarProduto(Long id, ProdutoDTO produtoDTO) {
        ProdutoEntity produto = this.montaProduto(produtoDTO);
        produto.setId(id);
        return Optional.of(this.produtoRepository.save(produto));
    }

    @Override
    public void deletarProduto(Long id) {
        this.produtoRepository.deleteById(id);
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
