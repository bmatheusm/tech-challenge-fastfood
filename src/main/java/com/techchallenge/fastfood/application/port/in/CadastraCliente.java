package com.techchallenge.fastfood.application.port.in;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;
import com.techchallenge.fastfood.application.dto.CadastroClienteDTO;

import java.util.Optional;

public interface CadastraCliente {
    Optional<ClienteEntity> cadastrarCliente(CadastroClienteDTO clienteDTO);
}
