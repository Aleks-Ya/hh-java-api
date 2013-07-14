package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.DictionaryException;

public interface IParser<T> {
    T parse(String content) throws ParseException, DictionaryException;
}
