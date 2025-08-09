package com.chabiaminesifeddine.vehiculeTrackingMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class webClientConfig {

    @Bean
    public WebClient webClient(ReactiveClientRegistrationRepository clients,
                               ServerOAuth2AuthorizedClientRepository authClients) {

        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2 =
                new ServletOAuth2AuthorizedClientExchangeFilterFunction(clients, authClients);

        oauth2.setDefaultClientRegistrationId("s4hana");

        return WebClient.builder()
                .apply(oauth2.oauth2Configuration())
                .baseUrl("https://sandbox.api.sap.com/s4hanacloud/sales-orders") // example
                .build();
    }


}
