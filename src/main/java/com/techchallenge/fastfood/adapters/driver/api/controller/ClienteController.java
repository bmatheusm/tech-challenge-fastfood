package com.techchallenge.fastfood.adapters.driver.api.controller;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;
import com.techchallenge.fastfood.application.port.in.BuscaClientePorCpf;
import com.techchallenge.fastfood.application.port.in.CadastraCliente;
import com.techchallenge.fastfood.application.dto.CadastroClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private BuscaClientePorCpf buscaClientePorCpf;

    @Autowired
    private CadastraCliente cadastraCliente;

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteEntity> identifica(@PathVariable String cpf) {
        Optional<ClienteEntity> cliente = buscaClientePorCpf.buscaPorCpf(cpf);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastro")
    public ResponseEntity<ClienteEntity> cadastra(@RequestBody CadastroClienteDTO cadastro) {
        Optional<ClienteEntity> cliente = cadastraCliente.cadastrarCliente(cadastro);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
