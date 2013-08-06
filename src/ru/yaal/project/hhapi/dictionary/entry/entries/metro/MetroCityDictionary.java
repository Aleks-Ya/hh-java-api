package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.dictionary.Dictionary;

import java.util.List;

public class MetroCityDictionary extends Dictionary<MetroCity> {
    public MetroCityDictionary() {
        super(MetroCity.NULL_METRO_CITY);
    }

    public MetroCityDictionary(List<MetroCity> metroCities) {
        super(MetroCity.NULL_METRO_CITY);
        for (MetroCity metroCity : metroCities) {
            addEntry(metroCity);
        }
    }

}
