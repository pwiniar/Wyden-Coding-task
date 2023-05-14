package wyden.coding.task.infrastructure;

import wyden.coding.task.domain.BookTicker;
import wyden.coding.task.domain.Price;
import wyden.coding.task.domain.Quantity;

import java.math.BigDecimal;

class ExampleMessages {

    static class BondTicker {
        static BookTicker getDefault() {
            return BookTicker.of("BTCUSDT", new BigDecimal("26919.40000000"),
                    new BigDecimal("0.02926000"), new BigDecimal("26919.41000000"),
                    new BigDecimal("1.83654000"));
        }
    }

}
