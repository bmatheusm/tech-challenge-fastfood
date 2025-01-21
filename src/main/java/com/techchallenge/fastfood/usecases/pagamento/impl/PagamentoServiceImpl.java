package com.techchallenge.fastfood.usecases.pagamento.impl;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import com.techchallenge.fastfood.domain.entities.PedidoEntity;
import com.techchallenge.fastfood.domain.exception.BusinessException;
import com.techchallenge.fastfood.gateways.http.PagamentoHttpClient;
import com.techchallenge.fastfood.gateways.repository.PagamentoGateway;
import com.techchallenge.fastfood.gateways.repository.PedidoGateway;
import com.techchallenge.fastfood.infrastructure.dto.PagamentoDTO;
import com.techchallenge.fastfood.infrastructure.enums.ExceptionEnum;
import com.techchallenge.fastfood.infrastructure.enums.StatusPagamento;
import com.techchallenge.fastfood.infrastructure.enums.StatusPedido;
import com.techchallenge.fastfood.usecases.pagamento.PagamentoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
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

        if (!Objects.equals(pagamento.getValor(), pedidoEntity.getValorTotal())) {
            throw new BusinessException(ExceptionEnum.VALOR_INCORRETO);
        }

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setValor(pagamento.getValor());
        pagamentoEntity.setFormaPagamento(pagamento.getFormaPagamento());
        pagamentoEntity.setStatus(StatusPagamento.PENDENTE);
        pagamentoEntity.setPedido(pedidoEntity);
        pedidoEntity.setStatusPedido(StatusPedido.EM_PREPARACAO);

        pagamentoGateway.save(pagamentoEntity);
        pedidoGateway.save(pedidoEntity);
        pagamentoHttpClient.enviaPagamento(pagamentoEntity);
    }

    @Override
    public ResponseEntity<String> consultarStatusPagamentoPedido(Long idPedido) {
        PagamentoEntity pagamentoEntity = pagamentoGateway.findByPedidoId(idPedido);
        if (pagamentoEntity == null) {
            return new ResponseEntity<>("Não existe pagamento para este pedido", HttpStatusCode.valueOf(400));
        }
        return ResponseEntity.ok(pagamentoEntity.getStatus().name());
    }
}
