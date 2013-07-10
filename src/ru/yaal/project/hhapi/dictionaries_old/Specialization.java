package ru.yaal.project.hhapi.dictionaries_old;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import lombok.Data;

@Data
@Deprecated
public class Specialization extends AbstractDictionaryEntry {
	private String profarea_id;
	private String profarea_name;
}
