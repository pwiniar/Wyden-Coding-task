package wyden.coding.task.infrastructure.marshaller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import wyden.coding.task.domain.BookTicker;


@AllArgsConstructor
public class JsonMarshaller {

    private final ObjectMapper mapper;

    public String writeValueAsString(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public BookTicker getBookTicker(String value, Class<BookTicker> type) {
        try {
            return mapper.readValue(value, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
