package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.DictionariesContainer;

public class SmallDictionariesParser extends AbstractParser<DictionariesContainer> {
    @Override
    public DictionariesContainer parse(String content) {
        return gson.fromJson(content, DictionariesContainer.class);
    }
}
