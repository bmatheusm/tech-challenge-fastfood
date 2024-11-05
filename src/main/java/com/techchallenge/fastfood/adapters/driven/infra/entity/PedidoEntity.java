package com.techchallenge.fastfood.adapters.driven.infra.entity;

import com.techchallenge.fastfood.domain.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido statusPedido;

    @ManyToOne
    @Setter
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @OneToMany
    private List<ProdutoEntity> produtos;

}
