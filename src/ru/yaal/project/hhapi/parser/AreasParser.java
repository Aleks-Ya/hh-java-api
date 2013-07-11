package ru.yaal.project.hhapi.parser;

import com.google.gson.reflect.TypeToken;
import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;

import java.util.ArrayList;
import java.util.List;

public class AreasParser extends AbstractParser<IDictionary<Area>> {
    @Override
    public IDictionary<Area> parse(String content) {
        List<Area> areaList = gson.fromJson(content, new TypeToken<List<Area>>() {}.getType());
        return new Dictionary<>(areaList);
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
