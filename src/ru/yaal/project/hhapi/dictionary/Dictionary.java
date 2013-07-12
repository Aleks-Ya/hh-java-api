package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.IDictionaryEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class Dictionary<V extends IDictionaryEntry> implements IDictionary<V> {
    protected Map<String, V> idMap = new HashMap<>();
    protected Map<String, V> nameMap = new HashMap<>();

    public Dictionary() {
    }

    public Dictionary(List<V> entryList) {
        idMap = listToIdMap(entryList);
        nameMap = listToNameMap(entryList);
    }

    /**
     * Упрощение для put(entry.getId(), entry);
     */
    public void putDictionaryEntry(V entry) {
        idMap.put(entry.getId(), entry);
    }

    @Override
    public int size() {
        return idMap.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String key : idMap.keySet()) {
            builder.append(getEntryById(key));
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public V getEntryById(String id) {
        return idMap.get(id.toUpperCase());
    }

    /**
     * Регистронезависимый поиск.
     */
    @Override
    public V getEntryByName(String name) {
        V entry = nameMap.get(name.toUpperCase());
        if (entry != null) {
            return entry;
        } else {
            throw new RuntimeException(format(
                    "В словаре не найдено значение по названию \"%s\".", name));
        }
    }

    protected Map<String, V> listToNameMap(List<V> entries) {
        Map<String, V> nameMap = new HashMap<>(entries.size());
        for (V area : entries) {
            nameMap.put(area.getName().toUpperCase(), area);
        }
        return nameMap;
    }

    protected Map<String, V> listToIdMap(List<V> entries) {
        Map<String, V> idMap = new HashMap<>(entries.size());
        for (V area : entries) {
            idMap.put(area.getId().toUpperCase(), area);
        }
        return idMap;
    }
}
