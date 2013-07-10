package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import java.net.URL;
import java.util.List;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@Data
public class Metro extends AbstractDictionaryEntry {
	private URL url;
	private List<MetroLine> lines;
}
