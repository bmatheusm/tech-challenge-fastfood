package com.techchallenge.fastfood.infrastructure.controller;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;
import com.techchallenge.fastfood.usecases.cliente.BuscaClientePorCpf;
import com.techchallenge.fastfood.usecases.cliente.CadastraCliente;
import com.techchallenge.fastfood.infrastructure.dto.CadastroClienteDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final BuscaClientePorCpf buscaClientePorCpf;
    private final CadastraCliente cadastraCliente;

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
