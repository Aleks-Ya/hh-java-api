package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@Data
public class MetroStation extends AbstractDictionaryEntry {
    public static final MetroStation NULL_STATION = new MetroStation();
    private Double lat;
    private Double lng;
    private Integer order;
    private MetroLine line;
}
