package com.techchallenge.fastfood.application.usecase.pedido;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PedidoEntity;
import com.techchallenge.fastfood.application.port.in.pedido.PedidoService;
import com.techchallenge.fastfood.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<PedidoEntity> listarTodos() {
        return this.pedidoRepository.findAll();
    }

}
