package com.techchallenge.fastfood.adapters.driver.api.controller;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;
import com.techchallenge.fastfood.application.dto.PedidoDTO;
import com.techchallenge.fastfood.application.port.in.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoEntity>> listaPedidos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<PedidoEntity> cadastrarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Optional<PedidoEntity> produto = pedidoService.cadastrarPedido(pedidoDTO);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<PedidoEntity> alterarStatusPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        PedidoEntity produto = pedidoService.alterarPedido(id, pedidoDTO);
        return ResponseEntity.ok().body(produto);
    }
}
