package com.techchallenge.fastfood.application.port.in.pagamento;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PagamentoEntity;
import com.techchallenge.fastfood.application.dto.PagamentoDTO;

public interface PagamentoService {
    void processaRetornoPagamento(PagamentoEntity pagamento);

    void fazPagamento(PagamentoDTO pagamento);
}