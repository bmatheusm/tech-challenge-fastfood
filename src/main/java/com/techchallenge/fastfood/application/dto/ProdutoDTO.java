package com.techchallenge.fastfood.application.dto;

import com.techchallenge.fastfood.domain.enums.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProdutoDTO {

    private String nome;
    private String descricao;
    private Double preco;
    private CategoriaProduto categoria;
    
}
