package com.chabiaminesifeddine.vehiculeTrackingMicroservice.controller;


import com.chabiaminesifeddine.vehiculeTrackingMicroservice.service.orderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class orderController {

    private final orderService orderService;

    @GetMapping("/{orderId}")
    public Mono<String> fetchOrder(@PathVariable String orderId) {
        return orderService.getVehicleOrder(orderId);
    }

}
