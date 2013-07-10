package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.IDicrionaryEntry;

public interface IDictionary<T extends IDicrionaryEntry> {
    T getEntryById(String id);
    void putDictionaryEntry(T entry);
    int size();
}
