package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@Data
public class MetroStation extends AbstractDictionaryEntry {
	private Double lat;
	private Double lng;
	private Integer order;
}
