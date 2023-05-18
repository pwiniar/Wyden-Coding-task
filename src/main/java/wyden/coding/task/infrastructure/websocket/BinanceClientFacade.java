package wyden.coding.task.infrastructure.websocket;

import java.util.function.Consumer;


public class BinanceClientFacade {

    private final BinanceEndpoint endpoint;

    public BinanceClientFacade(BinanceEndpoint endpoint) {
        this.endpoint = endpoint;
        endpoint.connect();
    }

    public void subscribeForTrade() {
        endpoint.subscribeForTrade();
    }
}

