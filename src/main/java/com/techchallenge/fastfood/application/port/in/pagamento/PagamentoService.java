package com.techchallenge.fastfood.application.port.in.pagamento;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.infrastructure.dto.PagamentoDTO;

public interface PagamentoService {
    void processaRetornoPagamento(PagamentoEntity pagamento);

    void fazPagamento(PagamentoDTO pagamento);
}