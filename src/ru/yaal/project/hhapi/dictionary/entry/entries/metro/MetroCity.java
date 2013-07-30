package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.net.URL;

public class MetroCity extends AbstractDictionaryEntry {
    public static final MetroCity NULL_METRO_CITY = new MetroCity();
    public static final MetroCityDictionary CITIES = MetroInitializer.getInstance().getMetroCities();
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL url;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private MetroLineDictionary lines = new MetroLineDictionary();
}
