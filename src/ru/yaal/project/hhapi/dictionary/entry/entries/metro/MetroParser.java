package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.parser.AbstractParser;

final class MetroParser extends AbstractParser<MetroCityDictionary> {
    @Override
    public MetroCityDictionary parse(String content) {
        return getGson().fromJson(content, MetroCityDictionary.class);
    }
}
