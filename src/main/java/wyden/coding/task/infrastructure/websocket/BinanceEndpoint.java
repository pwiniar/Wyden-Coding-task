package wyden.coding.task.infrastructure.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.tyrus.client.ClientManager;
import wyden.coding.task.infrastructure.Subscribe;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
@Slf4j
class BinanceEndpoint extends Endpoint {

    private static final String URL = "wss://stream.binance.com:9443/ws";

    private final ClientManager client;
    private final ClientEndpointConfig config;
    private final ObjectMapper mapper;
    private final Consumer<String> callBack;

    private Session session;

    public void connect() {
        try {
            this.session = client.connectToServer(this, config, new URI(URL));
        } catch (DeploymentException | IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler((MessageHandler.Whole<String>) callBack::accept);
    }

    void subscribeForTrade() {
        try {
            String value = mapper.writeValueAsString(Subscribe.of(1, List.of("btcusdt@trade")));
            session.getBasicRemote().sendText(value);
            log.info("send request for subscription {}", value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
