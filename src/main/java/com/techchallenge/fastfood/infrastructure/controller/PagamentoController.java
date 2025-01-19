package com.techchallenge.fastfood.infrastructure.controller;

import com.techchallenge.fastfood.infrastructure.dto.PagamentoDTO;
import com.techchallenge.fastfood.usecases.pagamento.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/pagar")
    public void enviaPagamento(@RequestBody PagamentoDTO payloadPagamento) {
        pagamentoService.fazPagamento(payloadPagamento);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<String> consultarStatusPagamentoPedido(@PathVariable Long idPedido) {
        return pagamentoService.consultarStatusPagamentoPedido(idPedido);
    }
}
