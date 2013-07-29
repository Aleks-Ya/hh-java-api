package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.DictionariesContainer;

public class SmallDictionariesParser extends AbstractParser<DictionariesContainer> {
    @Override
    public DictionariesContainer parse(String content) {
        return getGson().fromJson(content, DictionariesContainer.class);
    }
}
