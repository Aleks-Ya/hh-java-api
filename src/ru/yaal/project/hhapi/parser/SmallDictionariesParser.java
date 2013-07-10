package ru.yaal.project.hhapi.parser;

import com.google.gson.Gson;
import ru.yaal.project.hhapi.dictionary.DictionariesContainer;

public class SmallDictionariesParser implements IParser<DictionariesContainer> {
    @Override
    public DictionariesContainer parse(String content) {
        Gson gson = new Gson();
        return gson.fromJson(content, DictionariesContainer.class);
    }
}
