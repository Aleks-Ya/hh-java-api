package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroDictionary;

public class MetroParser extends AbstractParser<MetroDictionary> {
    @Override
    public MetroDictionary parse(String content) {
        return gson.fromJson(content, MetroDictionary.class);
    }
}
