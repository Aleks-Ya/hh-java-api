package ru.yaal.project.hhapi.dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.entry.IDictionaryEntry;

import java.util.*;

public class Dictionary<V extends IDictionaryEntry> implements IDictionary<V> {
    private static final Logger LOG = LoggerFactory.getLogger(Dictionary.class);
    protected Map<String, V> idMap = new HashMap<>();
    protected Map<String, V> nameMap = new HashMap<>();
    private V nullObject;

    public Dictionary(V nullObject) {
        this.nullObject = nullObject;
    }

    public Dictionary(List<V> entryList, V nullObject) throws DictionaryException {
        for (V entry : entryList) {
            addEntry(entry);
        }
        this.nullObject = nullObject;
    }

    /**
     * Упрощение для put(entry.getId(), entry);
     */
    public void addEntry(V entry) throws DictionaryException {
        putId(entry);
        putName(entry);
    }

    protected void putName(V entry) throws DictionaryException {
        if (entry.getName() == null) {
            throw new DictionaryException("Имя не может быть null (id %s).", entry.getId());
        }
        String name = entry.getName().toUpperCase();
        if (nameMap.containsKey(name)) {
            throw new DictionaryException("Повторяющееся имя: %s.", name);
        }
        nameMap.put(name, entry);
    }

    protected void putId(V entry) throws DictionaryException {
        if (entry.getId() == null){
            throw new DictionaryException("Ключ не может быть null (имя %s).", entry.getName());
        }
        String id = entry.getId().toUpperCase();
        if (idMap.containsKey(id)) {
            throw new DictionaryException("Повторяющийся ключ: %s.", id);
        }
        idMap.put(id, entry);
    }

    @Override
    public int size() {
        return idMap.size();
    }

    @Override
    public List<V> toList() {
        return new ArrayList<>(idMap.values());
    }

    @Override
    public Map<String, V> toIdMap() {
        return idMap;
    }

    @Override
    public Map<String, V> toNameMap() {
        return nameMap;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (String key : idMap.keySet()) {
            if (builder.length() != 1) {
                builder.append(",");
            }
            builder.append(getById(key));
        }
        builder.append("}");
        return builder.toString();
    }

    @Override
    public boolean hasId(String id) {
        return idMap.containsKey(id.toUpperCase());
    }

    @Override
    public boolean hasName(String name) {
        return nameMap.containsKey(name.toUpperCase());
    }

    @Override
    public V getById(String id) {
        V entry = idMap.get(id.toUpperCase());
        return (entry != null) ? entry : getNullObject(id);
    }

    /**
     * Регистронезависимый поиск.
     */
    @Override
    public V getByName(String name) {
        V entry = nameMap.get(name.toUpperCase());
        return (entry != null) ? entry : getNullObject(name);
    }

    @Override
    public Iterator<V> iterator() {
        return toList().iterator();
    }

    protected V getNullObject(String idOrName) {
        LOG.warn("Объект не найден по {}. Возвращаю NullObject.", idOrName);
        return nullObject;
    }
}
