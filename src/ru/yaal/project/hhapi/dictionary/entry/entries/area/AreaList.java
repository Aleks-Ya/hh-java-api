package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import lombok.Getter;
import ru.yaal.project.hhapi.dictionary.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class AreaList extends Dictionary<Area> {
    @Getter
    private Map<String, Area> flatMap = new HashMap<>();
    private Map<String, Area> nameMap = new HashMap<>();

    public AreaList(List<Area> tree) {
        super(tree);
        List<Area> flatList = areaTreeToFlatList(tree);
        for (Area area : flatList) {
            flatMap.put(area.getId(), area);
        }
        nameMap = makeNameMap(flatList);
    }

    @Override
    public Area getEntryById(String id) {
        Area area = flatMap.get(id);
        if (area != null) {
            return area;
        } else {
            throw new RuntimeException(format(
                    "В словаре не найдено значение по ключу \"%s\".", id));
        }
    }

    /**
     * Регистронезависимый поиск.
     */
    public Area getEntryByName(String name) {
        Area area = nameMap.get(name.toUpperCase());
        if (area != null) {
            return area;
        } else {
            throw new RuntimeException(format(
                    "В словаре не найдено значение по названию \"%s\".", name));
        }
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

    private Map<String, Area> makeNameMap(List<Area> areas) {
        Map<String, Area> nameMap = new HashMap<>(areas.size());
        for (Area area : areas) {
            nameMap.put(area.getName().toUpperCase(), area);
        }
        return nameMap;
    }
}
