package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroList;

public class MetroParser extends AbstractParser<MetroList> {
    @Override
    public MetroList parse(String content) throws DictionaryException {
        return gson.fromJson(content, MetroList.class);
    }
}
