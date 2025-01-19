package com.techchallenge.fastfood.infrastructure.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {
    RECEBIDO(1,"Recebido", 2),
    EM_PREPARACAO(2,"Em preparação", 3),
    PRONTO(3,"Pronto", 4),
    FINALIZADO(4,"Finalizado", 4),
    CANCELADO(5,"Cancelado", 5);

    private int id;
    private String descricao;
    private int next;

    StatusPedido(int id, String descricao, int next) {
        this.id = id;
        this.descricao = descricao;
        this.next = next;
    }

    public StatusPedido getNext() {
        return StatusPedido.values()[this.next];
    }
}
