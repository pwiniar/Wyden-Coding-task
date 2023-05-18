package wyden.coding.task.infrastructure.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class BinanceClientFacadeTest {

    private BinanceClientFacade sut;
    private MockedSession session;

    @BeforeEach
    public void setUp() {
        MockedBinanceEndpoint endpoint = new MockedBinanceEndpoint(new MockClientManager(), ClientEndpointConfig.Builder.create().build(),
                new ObjectMapper());
        this.session = new MockedSession();
        endpoint.onOpen(session, null);
        this.sut = new BinanceClientFacade(endpoint);
    }

    @Test
    @DisplayName("should connect to server endpoint subscribe for trade data and get confirmation about subscription")
    void name() {
        List<String> elements = new ArrayList<>();
        sut.subscribeForTrade(elements::add);

        session.messageHandler.onMessage("{\"result\":null,\"id\":1}");
        Assertions.assertEquals(1, elements.size());
        Assertions.assertTrue(elements.contains("{\"result\":null,\"id\":1}"));
    }


}
