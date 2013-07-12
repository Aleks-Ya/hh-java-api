package ru.yaal.project.hhapi.dictionary.entry;

import lombok.Data;

@Data
public abstract class AbstractDictionaryEntry implements IDictionaryEntry {
	protected String id;
	protected String name;
}
