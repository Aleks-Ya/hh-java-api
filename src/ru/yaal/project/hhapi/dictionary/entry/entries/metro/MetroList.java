package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.dictionary.Dictionary;

import java.util.List;

public class MetroList extends Dictionary<MetroCity> {

    public MetroList(List<MetroCity> metroCities) {
        for (MetroCity metroCity : metroCities) {
            putDictionaryEntry(metroCity);
        }
    }
}
