package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import ru.yaal.project.hhapi.parser.AbstractParser;
import ru.yaal.project.hhapi.parser.ParseException;

final class ProfessionalFieldsParser extends AbstractParser<ProfessionalFieldDictionary> {
    @Override
    public ProfessionalFieldDictionary parse(String content) throws ParseException {
        return getGson().fromJson(content, ProfessionalFieldDictionary.class);
    }
}
