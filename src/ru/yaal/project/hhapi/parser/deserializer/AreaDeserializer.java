package ru.yaal.project.hhapi.parser.deserializer;

import com.google.gson.*;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AreaDeserializer implements JsonDeserializer<AreaDictionary> {

    @Override
    public AreaDictionary deserialize(JsonElement element, Type type,
                                      JsonDeserializationContext context) throws JsonParseException {
        try {
            List<Area> areas = new ArrayList<>();
            for (JsonElement area : element.getAsJsonArray()) {
                areas.add(parseArea(area, null));
            }
            return new AreaDictionary(areas);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }

    private Area parseArea(JsonElement element, Area parentArea) throws MalformedURLException, DictionaryException {
        JsonObject object = (JsonObject) element;
        String id = object.get("id").getAsString();
        if (id == null || id.isEmpty()) return Area.NULL_AREA;
        Area newArea = new Area();
        newArea.setId(id);
        newArea.setName(object.get("name").getAsString());
        JsonElement url = object.get("url");
        if (url != null) {
            newArea.setUrl((!url.isJsonNull()) ? new URL(url.getAsString()) : null);
        }
        newArea.setParent(parentArea);

        JsonElement nestedAreas = object.get("areas");
        if (nestedAreas.isJsonArray()) {
            List<Area> nestedList = new ArrayList<>();
            for (JsonElement nested : nestedAreas.getAsJsonArray()) {
                nestedList.add(parseArea(nested, newArea));
            }
            newArea.setAreas(new AreaDictionary(nestedList));
        }

        return newArea;
    }
}