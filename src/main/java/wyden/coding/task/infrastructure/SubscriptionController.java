package wyden.coding.task.infrastructure;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Expose a REST endpoint to manage exis2ng subscrip2ons, for example add a new subscrip2on or
//        unsubscribe from an already subscribed symbol.

@RestController
@AllArgsConstructor
class SubscriptionController {

    private final BinanceClient client;

    @GetMapping("/")
    public List<SubscriptionView> getAllSubscriptions() {
        return client.getAllSubscriptions();
    }

    @PutMapping("/")
    public ResponseEntity<HttpStatusCode> addNewSubscription(@RequestBody String symbol) {
        if (!client.hasSubscription()) {
            client.addSubscription(symbol);
        }
        return ResponseEntity.of(Optional.of(HttpStatusCode.valueOf(200)));
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatusCode> removeSubscription(@RequestBody String symbol) {
        if (client.hasSubscription()) {
            client.removeSubscription(symbol);
            return ResponseEntity.of(Optional.of(HttpStatusCode.valueOf(200)));
        }
        return ResponseEntity.of(Optional.of(HttpStatusCode.valueOf(404)));
    }
}
