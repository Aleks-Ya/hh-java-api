package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;

import java.util.List;

public class MetroList extends Dictionary<MetroCity> {

    public MetroList(List<MetroCity> metroCities) throws DictionaryException {
        for (MetroCity metroCity : metroCities) {
            putDictionaryEntry(metroCity);
        }
    }
}
