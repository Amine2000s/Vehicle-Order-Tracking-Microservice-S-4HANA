package com.chabiaminesifeddine.vehiculeTrackingMicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class orderService {

    private final WebClient webClient;

    public Mono<String> getVehicleOrder(String orderId) {
        return webClient.get()
                .uri("/A_SalesOrder('" + orderId + "')")
                .retrieve()
                .bodyToMono(String.class);
    }

}
