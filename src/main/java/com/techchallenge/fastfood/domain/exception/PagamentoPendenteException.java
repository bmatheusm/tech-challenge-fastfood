package com.techchallenge.fastfood.domain.exception;

public class PagamentoPendenteException extends RuntimeException{
    public PagamentoPendenteException(Long pedidoId) {
        super("O pagamento do pedido " + pedidoId + " ainda está pendente.");
    }
}
