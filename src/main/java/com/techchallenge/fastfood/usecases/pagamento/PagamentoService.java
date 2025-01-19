package com.techchallenge.fastfood.usecases.pagamento;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.infrastructure.dto.PagamentoDTO;

public interface PagamentoService {
    void processaRetornoPagamento(PagamentoEntity pagamento);

    void fazPagamento(PagamentoDTO pagamento);

    String consultarStatusPagamentoPedido(Long idPedido);
}