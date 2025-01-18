package com.techchallenge.fastfood.adapters.driver.api.controller;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PagamentoEntity;
import com.techchallenge.fastfood.application.port.in.pagamento.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class StatusPagamentoWebhookController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/status-pagamento")
    public void handleWebhook(@RequestBody PagamentoEntity payloadPagamento) {
        pagamentoService.processaRetornoPagamento(payloadPagamento);
    }
}