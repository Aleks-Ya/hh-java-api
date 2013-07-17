package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;

public class ProfessionalFieldsParser extends AbstractParser<ProfessionalFieldDictionary> {
    @Override
    public ProfessionalFieldDictionary parse(String content) throws ParseException {
        return gson.fromJson(content, ProfessionalFieldDictionary.class);
    }
}
