package wyden.coding.task.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@ToString
public class Quantity {

    private Price quantity;

}
