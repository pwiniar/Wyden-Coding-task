package wyden.coding.task.infrastructure;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.impl.TypeSerializerBase;
import wyden.coding.task.domain.Price;

import java.io.IOException;
import java.math.BigDecimal;

public class PriceSerializer extends JsonDeserializer<Price> {

    @Override
    public Price deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return Price.of(new BigDecimal(jsonParser.getText()));
    }
}
