package com.techchallenge.fastfood.usecases.cliente;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;
import com.techchallenge.fastfood.infrastructure.dto.CadastroClienteDTO;

import java.util.Optional;

public interface CadastraCliente {
    Optional<ClienteEntity> cadastrarCliente(CadastroClienteDTO clienteDTO);
}
