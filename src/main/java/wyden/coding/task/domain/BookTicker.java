package wyden.coding.task.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import wyden.coding.task.infrastructure.PriceSerializer;

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
    @JsonDeserialize(using = PriceSerializer.class)
    private Price bestBidPrice;
    @JsonProperty("B")
    @JsonDeserialize(using = PriceSerializer.class)
    private Price bestBidQuantity;
    @JsonProperty("a")
    @JsonDeserialize(using = PriceSerializer.class)
    private Price bestAskPrice;
    @JsonProperty("A")
    @JsonDeserialize(using = PriceSerializer.class)
    private Price bestAskQuantity;
}
