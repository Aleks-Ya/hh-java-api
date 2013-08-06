package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import ru.yaal.project.hhapi.parser.AbstractParser;

final class AreasParser extends AbstractParser<AreaDictionary> {
    @Override
    public AreaDictionary parse(String content) {
        return getGson().fromJson(content, AreaDictionary.class);
    }
}
