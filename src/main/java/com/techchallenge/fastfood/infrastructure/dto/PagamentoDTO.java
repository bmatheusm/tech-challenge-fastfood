package com.techchallenge.fastfood.infrastructure.dto;

import com.techchallenge.fastfood.infrastructure.enums.FormaPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    @NotNull
    private Double valor;

    @NotNull
    private FormaPagamento formaPagamento;

    @NotNull
    private Long idPedido;
}
