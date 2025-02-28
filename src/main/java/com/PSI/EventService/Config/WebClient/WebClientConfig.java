package com.PSI.EventService.Config.WebClient;

import com.PSI.EventService.Clients.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    ApiProperties apiProperties;

    @Bean
    TicketClient ticketClient() {

        WebClient client = WebClient.builder()
                .baseUrl(apiProperties.getTicketBaseUrl())
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(client)).build();
        return factory.createClient(TicketClient.class);
    }
}
