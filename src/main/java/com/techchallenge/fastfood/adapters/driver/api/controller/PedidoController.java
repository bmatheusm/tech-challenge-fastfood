package com.techchallenge.fastfood.adapters.driver.api.controller;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;
import com.techchallenge.fastfood.application.port.in.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoEntity>> listaPedidos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }
}
