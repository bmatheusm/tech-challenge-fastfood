package com.techchallenge.fastfood.adapters.driver.api.controller;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;
import com.techchallenge.fastfood.adapters.driven.infra.entity.ProdutoEntity;
import com.techchallenge.fastfood.application.dto.ProdutoDTO;
import com.techchallenge.fastfood.application.port.in.produto.ProdutoService;
import com.techchallenge.fastfood.domain.enums.CategoriaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProdutoEntity>> listaProdutosCategoria(@PathVariable CategoriaProduto categoriaProduto) {
        return ResponseEntity.ok(produtoService.listarTodosDaCategoria(categoriaProduto));
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Optional<ProdutoEntity> produto = produtoService.cadastrarProduto(produtoDTO);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> editarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<ProdutoEntity> produto = produtoService.editarProduto(id, produtoDTO);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoEntity> deletarProduto(@PathVariable Long id) {
        this.produtoService.deletarProduto(id);
        return ResponseEntity.ok().build();
    }
}
