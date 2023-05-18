package wyden.coding.task.infrastructure;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wyden.coding.task.infrastructure.controller.SubscriptionView;
import wyden.coding.task.infrastructure.websocket.BinanceClientFacade;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
class SubscriptionController {

    private final BinanceClientFacade client;

    @GetMapping("/")
    public List<SubscriptionView> getAllSubscriptions() {
        client.subscribeForTrade();
        return null;
    }

    @PutMapping("/")
    public ResponseEntity<HttpStatusCode> addNewSubscription(@RequestBody String symbol) {
//        if (!client.hasSubscription()) {
//            client.addSubscription(symbol);
//        }
        return ResponseEntity.of(Optional.of(HttpStatusCode.valueOf(200)));
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatusCode> removeSubscription(@RequestBody String symbol) {
//        if (client.hasSubscription()) {
//            client.removeSubscription(symbol);
//            return ResponseEntity.of(Optional.of(HttpStatusCode.valueOf(200)));
//        }
        return ResponseEntity.of(Optional.of(HttpStatusCode.valueOf(404)));
    }
}
