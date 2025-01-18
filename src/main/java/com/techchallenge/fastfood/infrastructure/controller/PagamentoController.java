package com.techchallenge.fastfood.infrastructure.controller;

import com.techchallenge.fastfood.application.port.in.pagamento.PagamentoService;
import com.techchallenge.fastfood.infrastructure.dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/pagar")
    public void enviaPagamento(@RequestBody PagamentoDTO payloadPagamento) {
        pagamentoService.fazPagamento(payloadPagamento);
    }
}
