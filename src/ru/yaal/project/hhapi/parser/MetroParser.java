package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;

public class MetroParser extends AbstractParser<MetroCityDictionary> {
    @Override
    public MetroCityDictionary parse(String content) {
        return gson.fromJson(content, MetroCityDictionary.class);
    }
}
