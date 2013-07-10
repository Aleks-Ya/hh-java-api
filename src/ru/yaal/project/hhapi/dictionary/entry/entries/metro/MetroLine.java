package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import java.util.List;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@Data
public class MetroLine extends AbstractDictionaryEntry {
	private String hex_color;
	private List<MetroStation> stations;
}
