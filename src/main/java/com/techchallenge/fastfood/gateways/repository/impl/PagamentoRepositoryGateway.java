package com.techchallenge.fastfood.gateways.repository.impl;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.gateways.repository.PagamentoGateway;
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
}
