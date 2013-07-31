package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.entry.entries.small.SmallDictionariesContainer;

public class SmallDictionariesParser extends AbstractParser<SmallDictionariesContainer> {
    @Override
    public SmallDictionariesContainer parse(String content) {
        return getGson().fromJson(content, SmallDictionariesContainer.class);
    }
}
