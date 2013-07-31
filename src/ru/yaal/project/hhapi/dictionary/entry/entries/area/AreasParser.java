package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import ru.yaal.project.hhapi.parser.AbstractParser;
import ru.yaal.project.hhapi.parser.ParseException;

final class AreasParser extends AbstractParser<AreaDictionary> {
    @Override
    public AreaDictionary parse(String content) throws ParseException {
        return getGson().fromJson(content, AreaDictionary.class);
    }
}
