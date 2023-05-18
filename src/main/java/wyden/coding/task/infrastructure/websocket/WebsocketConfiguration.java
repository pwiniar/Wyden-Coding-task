package wyden.coding.task.infrastructure.websocket;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.ClientEndpointConfig;
import org.glassfish.tyrus.client.ClientManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WebsocketConfiguration {

    @Bean
    BinanceClientFacade binanceClientFacade() {
        return new BinanceClientFacade(new BinanceEndpoint(ClientManager.createClient(),
                ClientEndpointConfig.Builder.create().build(), new ObjectMapper(), System.err::println));
    }

}
