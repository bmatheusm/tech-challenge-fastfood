package com.techchallenge.fastfood.usecases.pagamento.impl;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.domain.entities.PedidoEntity;
import com.techchallenge.fastfood.gateways.http.PagamentoHttpClient;
import com.techchallenge.fastfood.gateways.repository.PagamentoGateway;
import com.techchallenge.fastfood.gateways.repository.PedidoGateway;
import com.techchallenge.fastfood.infrastructure.dto.PagamentoDTO;
import com.techchallenge.fastfood.infrastructure.enums.StatusPagamento;
import com.techchallenge.fastfood.usecases.pagamento.PagamentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoGateway pagamentoGateway;

    @Autowired
    private PagamentoHttpClient pagamentoHttpClient;

    @Autowired
    private PedidoGateway pedidoGateway;

    @Override
    public void processaRetornoPagamento(PagamentoEntity pagamento) {
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamentoGateway.save(pagamento);
    }

    @Override
    public void fazPagamento(PagamentoDTO pagamento) {
        PedidoEntity pedidoEntity = pedidoGateway.findById(pagamento.getIdPedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido com id " + pagamento.getIdPedido() + " não encontrado"));

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setValor(pagamento.getValor());
        pagamentoEntity.setFormaPagamento(pagamento.getFormaPagamento());
        pagamentoEntity.setStatus(StatusPagamento.PENDENTE);
        pagamentoEntity.setPedido(pedidoEntity);

        pagamentoGateway.save(pagamentoEntity);
        pagamentoHttpClient.enviaPagamento(pagamentoEntity);
    }

    @Override
    public String consultarStatusPagamentoPedido(Long idPedido) {
        PagamentoEntity pagamentoEntity = pagamentoGateway.findByPedidoId(idPedido);
        return pagamentoEntity.getStatus().name();
    }
}
