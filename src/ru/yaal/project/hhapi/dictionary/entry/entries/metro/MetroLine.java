package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.IDictionary;

public class MetroLine extends MetroCity {
    public static final MetroLine NULL_METRO_LINE = new MetroLine();
    @Getter
    @Setter
    private String hexColor;
    @Getter
    @Setter
    private IDictionary<MetroStation> stations;
    @Getter
    @Setter
    private MetroCity city;
}
