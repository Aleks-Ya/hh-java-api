package ru.yaal.project.hhapi.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.parser.deserializer.*;
import ru.yaal.project.hhapi.vacancy.Salary;

import java.util.Date;

public abstract class AbstractParser<T> implements IParser<T> {
    protected final Gson gson;

    protected AbstractParser() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer())
                .registerTypeAdapter(Salary.class, new SalaryDeserializer())
                .registerTypeAdapter(MetroCityDictionary.class, new MetroDeserializer())
                .registerTypeAdapter(AreaDictionary.class, new AreaDeserializer())
                .registerTypeAdapter(ProfessionalFieldDictionary.class, new ProfessionalFieldDeserializer());
        gson = builder.create();
    }
}
