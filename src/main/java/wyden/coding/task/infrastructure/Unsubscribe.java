package wyden.coding.task.infrastructure;

import lombok.*;

import java.util.List;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@ToString
class Unsubscribe {
    private final String method = Method.SUBSCRIBE.getMethodAsString();
    private int id;
    private List<String> params;

}
