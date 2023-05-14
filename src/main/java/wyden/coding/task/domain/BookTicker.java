package wyden.coding.task.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.math.BigDecimal;


@ToString
public class BookTicker {
    @JsonProperty("s")
    private String symbol;
    @JsonProperty("b")
    private BigDecimal bestBidPrice;
    @JsonProperty("B")
    private BigDecimal bestBidQuantity;
    @JsonProperty("a")
    private BigDecimal bestAskPrice;
    @JsonProperty("A")
    private BigDecimal bestAskQuantity;
}
