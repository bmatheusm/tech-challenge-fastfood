package com.techchallenge.fastfood.gateways.repository.impl;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.gateways.repository.PagamentoGateway;
import com.techchallenge.fastfood.infrastructure.enums.StatusPagamento;
import com.techchallenge.fastfood.infrastructure.repository.JpaPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PagamentoRepositoryGateway implements PagamentoGateway {

    @Autowired
    private JpaPagamentoRepository pagamentoRepository;

    @Override
    public PagamentoEntity save(PagamentoEntity pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public boolean existsByPedidoIdAndPagamentoStatusAprovado(Long id) {
        return pagamentoRepository.existsByPedidoIdAndStatus(id, StatusPagamento.APROVADO);
    }

    @Override
    public PagamentoEntity findByPedidoId(Long id) {
        return pagamentoRepository.findByPedidoId(id);
    }
}
