package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.parser.AbstractParser;

final class SmallDictionariesParser extends AbstractParser<SmallDictionariesContainer> {
    @Override
    public SmallDictionariesContainer parse(String content) {
        return getGson().fromJson(content, SmallDictionariesContainer.class);
    }
}
