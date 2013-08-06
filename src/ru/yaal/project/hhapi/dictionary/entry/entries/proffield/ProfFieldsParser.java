package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import ru.yaal.project.hhapi.parser.AbstractParser;

final class ProfFieldsParser extends AbstractParser<ProfFieldDictionary> {
    @Override
    public ProfFieldDictionary parse(String content) {
        return getGson().fromJson(content, ProfFieldDictionary.class);
    }
}
