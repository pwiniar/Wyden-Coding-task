package wyden.coding.task.infrastructure.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.ClientEndpointConfig;
import org.glassfish.tyrus.client.ClientManager;
import wyden.coding.task.infrastructure.websocket.BinanceEndpoint;

class MockedBinanceEndpoint extends BinanceEndpoint {

    public MockedBinanceEndpoint(ClientManager client, ClientEndpointConfig config, ObjectMapper mapper) {
        super(client, config, mapper);
    }
}
