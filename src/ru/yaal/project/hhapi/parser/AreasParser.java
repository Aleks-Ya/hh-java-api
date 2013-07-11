package ru.yaal.project.hhapi.parser;

import com.google.gson.reflect.TypeToken;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;

import java.util.ArrayList;
import java.util.List;

public class AreasParser extends AbstractParser<List<Area>> {
    @Override
    public List<Area> parse(String content) {
        return gson.fromJson(content, new TypeToken<List<Area>>() {
        }.getType());
    }

    private List<Area> areaTreeToFlatList(List<Area> topAreas) {
        List<Area> result = new ArrayList<>(topAreas);
        for (Area area : topAreas) {
            List<Area> nestedAreas = area.getAreas();
            List<Area> flatNestedAreasList = areaTreeToFlatList(nestedAreas);
            result.addAll(flatNestedAreasList);
        }
        return result;
    }
}
