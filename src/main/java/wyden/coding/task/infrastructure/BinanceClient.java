package wyden.coding.task.infrastructure;

import lombok.extern.slf4j.Slf4j;
import wyden.coding.task.domain.Subscribe;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Slf4j
public class BinanceClient {

    private WebsocketClientEndpoint endpoint;
    private final String url;
    private final String symbol;
    private final JsonMarshaller jsonMarshaller;


    public BinanceClient(String url, String symbol, JsonMarshaller jsonMarshaller) {
        this.url = url;
        this.symbol = symbol;
        this.jsonMarshaller = jsonMarshaller;
    }

    public void connect() {
        try {
            this.endpoint = new WebsocketClientEndpoint(new URI(url + "/ws/" + symbol));
        } catch (
                URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }

    public void subscribeFor(String value) {
        String writeValueAsString = jsonMarshaller.writeValueAsString(Subscribe.of(1, Arrays.asList("btcusdt@" + value)));
        endpoint.sendMessage(writeValueAsString);
    }

    public void addHandler() {
        endpoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
            public void handleMessage(String message) {
                log.info(jsonMarshaller.getBookTicker(message).toString());
            }
        });
    }

    public List<SubscriptionView> getAllSubscriptions() {
        return Collections.emptyList();
    }

    public boolean hasSubscription() {
        return false;
    }

    public void addSubscription(String symbol) {

    }

    public void removeSubscription(String symbol) {


    }
}
