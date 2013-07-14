package ru.yaal.project.hhapi.parser;

import com.google.gson.reflect.TypeToken;
import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;

import java.util.List;

public class ProfessionalFieldsParser extends AbstractParser<IDictionary<ProfessionalField>> {
    @Override
    public IDictionary<ProfessionalField> parse(String content) throws ParseException {
        try {
            List<ProfessionalField> list = gson.fromJson(content, new TypeToken<List<ProfessionalField>>() {}.getType());
            return new Dictionary<>(list);
        } catch (DictionaryException e) {
            throw new ParseException(e);
        }
    }
}
