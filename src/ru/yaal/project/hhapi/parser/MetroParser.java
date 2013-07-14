package ru.yaal.project.hhapi.parser;

import com.google.gson.reflect.TypeToken;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroList;

import java.util.List;

public class MetroParser extends AbstractParser<MetroList> {
    @Override
    public MetroList parse(String content) throws DictionaryException {
        List<MetroCity> metroCities = gson.fromJson(content, new TypeToken<List<MetroCity>>() {}.getType());
        return new MetroList(metroCities);
    }
}
