package com.techchallenge.fastfood.domain.entities;

import com.techchallenge.fastfood.infrastructure.enums.FormaPagamento;
import com.techchallenge.fastfood.infrastructure.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagamento")
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento status;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido;
}
