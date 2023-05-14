package wyden.coding.task.application;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wyden.coding.task.infrastructure.BinanceWebSocketClient;

@Configuration
class ApplicationConfiguration {

    @Bean
    BinanceWebSocketClient binanceWebSocketClient(@Value("${binance.url}") String ulr, @Value("${binance.stream-symbol}") String symbol) {
        return new BinanceWebSocketClient(ulr, symbol);
    }

}
