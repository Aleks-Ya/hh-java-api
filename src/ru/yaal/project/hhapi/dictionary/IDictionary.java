package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.IDictionaryEntry;

import java.util.List;
import java.util.Map;

public interface IDictionary<T extends IDictionaryEntry> {
    T getEntryById(String id) throws DictionaryException;

    T getEntryByName(String name) throws DictionaryException;

    void putDictionaryEntry(T entry) throws DictionaryException;

    int size();

    List<T> toList();

    Map<String, T> toIdMap();

    Map<String, T> toNameMap();

}
