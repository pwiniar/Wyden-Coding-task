package wyden.coding.task.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.ClientEndpoint;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import wyden.coding.task.domain.BookTicker;
import wyden.coding.task.domain.Subscribe;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;


public class BinanceWebSocketClient {

    private final String url;
    private final String symbol;

    private WebsocketClientEndpoint clientEndpoint;

    public BinanceWebSocketClient(String url, String symbol) {
        this.url = url;
        this.symbol = symbol;
        connect();
    }

    private void connect() {
        try {

            this.clientEndpoint = new WebsocketClientEndpoint(new URI(url + "/ws/" + symbol));


            // add listener
            clientEndpoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    try {
                        System.err.println(objectMapper.readValue(message, BookTicker.class));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }

//                    System.out.println(message);
                }
            });

            ObjectMapper objectMapper = new ObjectMapper();
//            String writeValueAsString = objectMapper.writeValueAsString(Subscribe.of(1, Arrays.asList("btcusdt@aggTrade")));
            String writeValueAsString = objectMapper.writeValueAsString(Subscribe.of(1, Arrays.asList("btcusdt@bookTicker")));

            // send message to websocket
            clientEndpoint.sendMessage(writeValueAsString);
        } catch (
                URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        } catch (
                JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    void sendMessage() {

    }


}
