package com.techchallenge.fastfood.application.dto;

import com.techchallenge.fastfood.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PedidoDTO {
    private String cpf;
    private StatusPedido statusPedido;
    private List<Long> produtosId;
}
