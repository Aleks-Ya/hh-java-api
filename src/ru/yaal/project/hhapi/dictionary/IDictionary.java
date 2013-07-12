package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.IDictionaryEntry;

public interface IDictionary<T extends IDictionaryEntry> {
    T getEntryById(String id);

    T getEntryByName(String name);

    void putDictionaryEntry(T entry);

    int size();
}
