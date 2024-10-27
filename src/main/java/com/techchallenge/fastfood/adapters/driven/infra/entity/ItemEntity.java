package com.techchallenge.fastfood.adapters.driven.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techchallenge.fastfood.domain.enums.TipoItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoItem tipo;

    @ManyToMany(mappedBy = "itens")
    private List<PedidoEntity> pedidos = new ArrayList<>();
}
