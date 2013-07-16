package ru.yaal.project.hhapi.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroList;
import ru.yaal.project.hhapi.parser.deserializer.DateDeserializer;
import ru.yaal.project.hhapi.parser.deserializer.MetroDeserializer;
import ru.yaal.project.hhapi.parser.deserializer.SalaryDeserializer;
import ru.yaal.project.hhapi.vacancy.Salary;

import java.util.Date;

public abstract class AbstractParser<T> implements IParser<T> {
    protected final Gson gson;

    protected AbstractParser() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer())
                .registerTypeAdapter(Salary.class, new SalaryDeserializer())
                .registerTypeAdapter(MetroList.class, new MetroDeserializer());
        gson = builder.create();
    }
}
