package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.IDictionaryEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public abstract class TreeDictionary<V extends IDictionaryEntry> extends Dictionary<V> {
    protected Map<String, V> flatIdMap = new HashMap<>();
    protected Map<String, V> flatNameMap = new HashMap<>();

    public TreeDictionary(List<V> treeList) throws DictionaryException {
        super(treeList);
        List<V> flatList = treeToFlat(treeList);
        flatIdMap = listToIdMap(treeToFlat(treeList));
        flatNameMap = listToNameMap(treeToFlat(treeList));
    }

    abstract protected List<V> treeToFlat(List<V> treeList);

    @Override
    public V getEntryById(String id) {
        V entry = flatIdMap.get(id);
        if (entry != null) {
            return entry;
        } else {
            throw new RuntimeException(format(
                    "В словаре не найдено значение по ключу \"%s\".", id));
        }
    }

    @Override
    public V getEntryByName(String name) {
        V entry = flatNameMap.get(name.toUpperCase());
        if (entry != null) {
            return entry;
        } else {
            throw new RuntimeException(format(
                    "В словаре не найдено значение по названию \"%s\".", name));
        }
    }

    @Override
    public int size() {
        return flatIdMap.size();
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
