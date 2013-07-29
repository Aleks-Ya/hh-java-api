package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;

public class AreasParser extends AbstractParser<AreaDictionary> {
    @Override
    public AreaDictionary parse(String content) throws ParseException {
        return getGson().fromJson(content, AreaDictionary.class);
    }
}
