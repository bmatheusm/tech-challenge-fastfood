package com.techchallenge.fastfood.application.usecase.pagamento;

import com.techchallenge.fastfood.adapters.driven.http.PagamentoHttpClient;
import com.techchallenge.fastfood.adapters.driven.infra.entity.PagamentoEntity;
import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;
import com.techchallenge.fastfood.application.dto.PagamentoDTO;
import com.techchallenge.fastfood.application.port.in.pagamento.PagamentoService;
import com.techchallenge.fastfood.domain.enums.StatusPagamento;
import com.techchallenge.fastfood.domain.repository.PagamentoRepository;
import com.techchallenge.fastfood.domain.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoHttpClient pagamentoHttpClient;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void processaRetornoPagamento(PagamentoEntity pagamento) {
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamentoRepository.save(pagamento);
    }

    @Override
    public void fazPagamento(PagamentoDTO pagamento) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(pagamento.getIdPedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido com id " + pagamento.getIdPedido() + " não encontrado"));

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setValor(pagamento.getValor());
        pagamentoEntity.setFormaPagamento(pagamento.getFormaPagamento());
        pagamentoEntity.setStatus(StatusPagamento.PENDENTE);
        pagamentoEntity.setPedido(pedidoEntity);

        pagamentoRepository.save(pagamentoEntity);
        pagamentoHttpClient.enviaPagamento(pagamentoEntity);
    }
}
