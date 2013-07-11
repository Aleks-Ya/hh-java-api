package ru.yaal.project.hhapi.parser.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Парсит дату в формате ISO 8601.
 */
public class DateDeserializer implements JsonDeserializer<Date> {

    public static Date parse(String input) throws java.text.ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
        if (input.endsWith("Z")) {
            input = input.substring(0, input.length() - 1) + "GMT-00:00";
        } else {
            int inset = 6;
            String s0 = input.substring(0, input.length() - inset);
            String s1 = input.substring(input.length() - inset, input.length());
            input = s0 + "GMT" + s1;
        }
        return df.parse(input);
    }

    @Override
    public Date deserialize(JsonElement element, Type type,
                            JsonDeserializationContext context) throws JsonParseException {
        try {
            String dateStr = element.getAsString();
            return parse(dateStr);
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }
}
