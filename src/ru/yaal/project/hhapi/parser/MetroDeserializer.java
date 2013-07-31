package ru.yaal.project.hhapi.parser;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.*;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MetroDeserializer implements JsonDeserializer<MetroCityDictionary> {
    private static final Logger LOG = LoggerFactory.getLogger(MetroCityDictionary.class);

    @Override
    public MetroCityDictionary deserialize(JsonElement element, Type type, JsonDeserializationContext context) {
        try {
            return new MetroCityDictionary(parseCities(element));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new JsonParseException(e);
        }
    }

    private List<MetroCity> parseCities(JsonElement element) throws MalformedURLException, DictionaryException {
        List<MetroCity> result = new ArrayList<>();
        if (!element.isJsonNull()) {
            for (JsonElement cityElement : element.getAsJsonArray()) {
                JsonObject cityObj = (JsonObject) cityElement;
                String cityId = cityObj.get("id").getAsString();
                if (cityId != null) {
                    MetroCity newCity = new MetroCity();
                    newCity.setId(cityId);
                    newCity.setName(cityObj.get("name").getAsString());

                    JsonElement url = cityObj.get("url");
                    newCity.setUrl((!url.isJsonNull()) ? new URL(url.getAsString()) : null);

                    JsonElement lines = cityObj.get("lines");
                    newCity.setLines(parseLines(lines, newCity));
                    result.add((newCity));
                } else {
                    result.add(MetroCity.NULL_METRO_CITY);
                }
            }
        }
        return result;
    }

    private MetroLineDictionary parseLines(JsonElement lines, MetroCity city) throws DictionaryException {
        List<MetroLine> result = new ArrayList<>();
        if (!lines.isJsonNull()) {
            for (JsonElement lineElement : lines.getAsJsonArray()) {
                JsonObject lineObj = (JsonObject) lineElement;
                String lineId = lineObj.get("id").getAsString();
                if (lineId != null) {
                    MetroLine newLine = new MetroLine();
                    newLine.setId(lineId);
                    newLine.setName(lineObj.get("name").getAsString());
                    newLine.setHexColor(lineObj.get("hex_color").getAsString());
                    newLine.setCity(city);
                    newLine.setStations(parseStations(lineObj.get("stations"), newLine));
                    result.add(newLine);
                } else {
                    result.add(MetroLine.NULL_METRO_LINE);
                }
            }
        }
        return new MetroLineDictionary(result);
    }

    private IDictionary<MetroStation> parseStations(JsonElement stationsElement, MetroLine line) throws DictionaryException {
        List<MetroStation> result = new ArrayList<>();
        if (!stationsElement.isJsonNull()) {
            for (JsonElement stationElement : stationsElement.getAsJsonArray()) {
                JsonObject stationObj = (JsonObject) stationElement;
                String id = stationObj.get("id").getAsString();
                if (id != null) {
                    MetroStation newStation = new MetroStation();
                    newStation.setId(id);
                    newStation.setName(stationObj.get("name").getAsString());
                    newStation.setLat(stationObj.get("lat").getAsDouble());
                    newStation.setLng(stationObj.get("lng").getAsDouble());
                    newStation.setLine(line);
                    newStation.setCity(line.getCity());
                    newStation.setOrder(stationObj.get("order").getAsInt());
                    result.add(newStation);
                } else {
                    result.add(MetroStation.NULL_METRO_STATION);
                }
            }
        }
        return new Dictionary<>(result, MetroStation.NULL_METRO_STATION);
    }
}
