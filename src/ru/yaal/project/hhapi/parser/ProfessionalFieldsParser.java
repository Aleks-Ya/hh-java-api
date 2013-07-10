package ru.yaal.project.hhapi.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;

import java.util.List;

public class ProfessionalFieldsParser implements IParser<List<ProfessionalField>> {
    @Override
    public List<ProfessionalField> parse(String content) {
        Gson gson = new Gson();
        return gson.fromJson(content, new TypeToken<List<ProfessionalField>>() {}.getType());
    }
}
