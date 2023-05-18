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
    List<String> messages = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        MockedBinanceEndpoint endpoint = new MockedBinanceEndpoint(new MockClientManager(), ClientEndpointConfig.Builder.create().build(),
                new ObjectMapper(), messages::add);
        this.session = new MockedSession();
        endpoint.onOpen(session, null);
        this.sut = new BinanceClientFacade(endpoint);
    }

    @Test
    @DisplayName("should connect to server endpoint subscribe for trade data and get confirmation about subscription")
    void name() {
        sut.subscribeForTrade();

        session.messageHandler.onMessage("{\"result\":null,\"id\":1}");
        Assertions.assertEquals(1, messages.size());
        Assertions.assertTrue(messages.contains("{\"result\":null,\"id\":1}"));
    }


}
