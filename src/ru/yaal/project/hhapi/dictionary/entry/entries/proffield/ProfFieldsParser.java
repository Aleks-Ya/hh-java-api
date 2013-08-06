package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import ru.yaal.project.hhapi.parser.AbstractParser;
import ru.yaal.project.hhapi.parser.ParseException;

final class ProfFieldsParser extends AbstractParser<ProfFieldDictionary> {
    @Override
    public ProfFieldDictionary parse(String content) throws ParseException {
        return getGson().fromJson(content, ProfFieldDictionary.class);
    }
}
