package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;

public class MetroStation extends MetroLine {
    public static final MetroStation NULL_METRO_STATION = new MetroStation();
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private MetroLine line;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Integer order;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Double lat;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Double lng;
}
