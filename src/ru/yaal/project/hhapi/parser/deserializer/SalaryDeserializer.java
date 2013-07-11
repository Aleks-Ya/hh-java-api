package ru.yaal.project.hhapi.parser.deserializer;

import com.google.gson.*;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.entries.Currency;
import ru.yaal.project.hhapi.vacancy.Salary;

import java.lang.reflect.Type;

public class SalaryDeserializer implements JsonDeserializer<Salary> {

    @Override
    public Salary deserialize(JsonElement element, Type type,
                              JsonDeserializationContext context) throws JsonParseException {
        try {
            JsonObject object = (JsonObject) element;

            JsonElement toElement = object.get("to");
            Integer to = (toElement.isJsonPrimitive()) ? toElement.getAsInt() : null;

            JsonElement fromElement = object.get("from");
            Integer from = (fromElement.isJsonPrimitive()) ? fromElement.getAsInt() : null;

            JsonElement currencyElement = object.get("currency");
            Currency currency = null;
            if (currencyElement.isJsonPrimitive()) {
                String currencyId = currencyElement.getAsString();
                currency = Dictionaries.getCurrency().getEntryById(currencyId);
            }

            return new Salary(from, to, currency);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}