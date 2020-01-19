package com.galaxy.framework.util;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateJsonDeserializer extends JsonDeserializer<Date> {

    /**     * @see JsonDeserializer#deserialize(JsonParser,     *      DeserializationContext)     */
    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context)      throws IOException, JsonProcessingException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(parser.getValueAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;

    }

}
