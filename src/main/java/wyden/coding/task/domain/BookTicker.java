package wyden.coding.task.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;


@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
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
