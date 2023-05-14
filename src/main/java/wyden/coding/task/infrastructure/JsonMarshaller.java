package wyden.coding.task.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import wyden.coding.task.domain.BookTicker;
import wyden.coding.task.domain.Subscribe;


@AllArgsConstructor
public class JsonMarshaller {

    private final ObjectMapper writer;
    private final ObjectMapper reader;

    public String writeValueAsString(Object value) {
        try {
            return writer.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public BookTicker getBookTicker(String value) {
        try {
            return reader.readValue(value, BookTicker.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
