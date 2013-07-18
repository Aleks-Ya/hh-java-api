package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;

public class MetroStation extends MetroLine {
    public static final MetroStation NULL_METRO_STATION = new MetroStation();
    @Getter
    @Setter
    private Double lat;
    @Getter
    @Setter
    private Double lng;
    @Getter
    @Setter
    private Integer order;
    @Getter
    @Setter
    private MetroLine line;

}
