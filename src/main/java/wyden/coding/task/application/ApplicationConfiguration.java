package wyden.coding.task.application;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wyden.coding.task.infrastructure.BinanceClient;
import wyden.coding.task.infrastructure.JsonMarshaller;

@Configuration
class ApplicationConfiguration {


    @Bean
    BinanceClient binanceWebSocketClient(@Value("${binance.url}") String ulr, @Value("${binance.stream-symbol}") String symbol,
                                         JsonMarshaller jsonMarshaller) {
        BinanceClient client = new BinanceClient(ulr, symbol, jsonMarshaller);
        client.connect();
        client.subscribeFor("bookTicker");
        client.addHandler();
        return client;
    }

    @Bean
    JsonMarshaller jsonMarshaller() {
        ObjectMapper writer = new ObjectMapper();
        writer.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ObjectMapper reader = new ObjectMapper();
        reader.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new JsonMarshaller(writer, reader);
    }

}
