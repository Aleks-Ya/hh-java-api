package ru.yaal.project.hhapi.dictionary.entry;

import ru.yaal.project.hhapi.dictionary.Dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public abstract class TreeDictionary<V extends IDictionaryEntry> extends Dictionary<V> {
    protected Map<String, V> flatIdMap = new HashMap<>();
    protected Map<String, V> flatNameMap = new HashMap<>();

    public TreeDictionary(List<V> treeList) {
        super(treeList);
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
}
