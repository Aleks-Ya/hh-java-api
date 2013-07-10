package ru.yaal.project.hhapi.dictionary;

import java.util.HashMap;
import java.util.List;

import ru.yaal.project.hhapi.dictionary.entry.IDicrionaryEntry;
import static java.lang.String.format;

public class Dictionary<V extends IDicrionaryEntry> extends HashMap<String, V> {
	private static final long serialVersionUID = -6113052989890227469L;

	public Dictionary() {
	}

	public Dictionary(List<V> entryList) {
		for (V entry : entryList) {
			putDictionaryEntry(entry);
		}
	}

	/**
	 * Упрощение для put(entry.getId(), entry);
	 */
	public void putDictionaryEntry(V entry) {
		put(entry.getId(), entry);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (String key : keySet()) {
			builder.append(get(key));
			builder.append("\n");
		}
		return builder.toString();
	}

	@Override
	public V get(Object key) {
		V value = super.get(key);
		if (value != null) {
			return value;
		} else {
			throw new RuntimeException(format(
					"В словаре не найдено значение по ключу \"%s\".", key));
		}
	}
}
