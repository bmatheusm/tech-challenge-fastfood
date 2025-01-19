package com.techchallenge.fastfood.gateways.repository.impl;

import com.techchallenge.fastfood.domain.entities.PedidoEntity;
import com.techchallenge.fastfood.gateways.repository.PedidoGateway;
import com.techchallenge.fastfood.infrastructure.repository.JpaPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PedidoRepositoryGateway implements PedidoGateway {

    private final JpaPedidoRepository pedidoRepository;

    @Override
    public List<PedidoEntity> findAllToDisplay() {
        List<PedidoEntity> pedidos = pedidoRepository.findAllToDisplay();

        return pedidos.stream()
                .sorted(Comparator.comparing(
                        (PedidoEntity p) -> p.getStatusPedido().getId(),
                        Comparator.reverseOrder()
                ).thenComparing(
                        PedidoEntity::getCriadoEm,
                        Comparator.reverseOrder()
                ))
                .toList();
    }

    @Override
    public Optional<PedidoEntity> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public PedidoEntity save(PedidoEntity pedidoEntity) {
        return pedidoRepository.save(pedidoEntity);
    }
}
