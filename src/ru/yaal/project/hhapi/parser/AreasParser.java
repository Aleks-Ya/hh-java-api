package ru.yaal.project.hhapi.parser;

import com.google.gson.reflect.TypeToken;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaList;

import java.util.List;

public class AreasParser extends AbstractParser<AreaList> {
    @Override
    public AreaList parse(String content) {
        List<Area> areaList = gson.fromJson(content, new TypeToken<List<Area>>() {}.getType());
        return new AreaList(areaList);
    }
}
