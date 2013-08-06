package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.IDictionaryEntry;

import java.util.List;
import java.util.Map;

public interface IDictionary<T extends IDictionaryEntry> extends Iterable<T> {

    boolean hasId(String id);

    boolean hasName(String name);

    T getById(String id);

    T getByName(String name);

    void addEntry(T entry);

    int size();

    List<T> toList();

    Map<String, T> toIdMap();

    Map<String, T> toNameMap();

}
