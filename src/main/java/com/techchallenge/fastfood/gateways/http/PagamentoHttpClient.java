package com.techchallenge.fastfood.gateways.http;

import com.techchallenge.fastfood.domain.entities.PagamentoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class PagamentoHttpClient {

    @Value("${external.api.endpoint}")
    private String paymentApiEndpoint;

    private final WebClient webClient;

    public PagamentoHttpClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void enviaPagamento(PagamentoEntity pagamento) {
        try {
            webClient.post().uri(paymentApiEndpoint)
                    .bodyValue(pagamento)
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnSuccess(response -> log.info("Resposta da aplicação de pagamento: {}", response))
                    .doOnError(error -> log.error("Erro ao enviar notificação: {}", error.getMessage()))
                    .block();
        } catch (Exception e) {
            log.error("Erro na comunicação com a aplicação externa: {}", e.getMessage());
            throw e;
        }
    }
}
