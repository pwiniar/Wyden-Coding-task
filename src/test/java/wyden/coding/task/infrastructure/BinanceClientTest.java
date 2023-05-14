package wyden.coding.task.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;

class BinanceClientTest {

    private WebsocketClientEndpoint client = new WebsocketClientEndpoint(URI.create("fake"));
    private BinanceClient binanceClient;


    @Test
    @DisplayName("should display bond ticker data")
    void name1() {

    }
}