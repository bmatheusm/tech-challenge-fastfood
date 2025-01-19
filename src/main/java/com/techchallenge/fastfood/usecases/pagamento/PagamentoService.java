package com.techchallenge.fastfood.usecases.pagamento;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.infrastructure.dto.PagamentoDTO;
import org.springframework.http.ResponseEntity;

public interface PagamentoService {
    void processaRetornoPagamento(PagamentoEntity pagamento);

    void fazPagamento(PagamentoDTO pagamento);

    ResponseEntity<String> consultarStatusPagamentoPedido(Long idPedido);
}