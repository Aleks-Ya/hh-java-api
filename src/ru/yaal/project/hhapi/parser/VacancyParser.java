package ru.yaal.project.hhapi.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.yaal.project.hhapi.parser.deserializer.DateDeserializer;
import ru.yaal.project.hhapi.search.VacanciesList;

import java.util.Date;

public class VacancyParser implements IParser<VacanciesList> {
    @Override
    public VacanciesList parse(String content) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = builder.create();
        return gson.fromJson(content, VacanciesList.class);
    }
}
