package com.techchallenge.fastfood.domain.enums;

public enum TipoItem {
    LANCHE(1,"Lanche"),
    ACOMPANHAMENTO(2,"Acompanhamento"),
    BEBIDA(3,"Bebida"),
    SOBREMESA(4,"Sobremesa");

    private int id;
    private String nome;

    TipoItem(int id, String nome) {}
}
