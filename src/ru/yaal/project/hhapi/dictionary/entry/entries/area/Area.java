package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@Data
@ToString(callSuper=true)
public class Area extends AbstractDictionaryEntry {
	private String parent_id;
	private URL url;
	private List<Area> areas = new ArrayList<Area>(0);
}
