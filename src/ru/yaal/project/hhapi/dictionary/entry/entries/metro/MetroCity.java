package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.net.URL;

/**
 * Город с метро.
 */
public class MetroCity extends AbstractDictionaryEntry {
    public static final MetroCity NULL_METRO_CITY = new MetroCity();
    public static final MetroCityDictionary CITIES = MetroInitializer.getInstance().getMetroCities();
    private URL url;
    private MetroLineDictionary lines = new MetroLineDictionary();

    public MetroLineDictionary getLines() {

        return lines;
    }

    public void setLines(MetroLineDictionary lines) {
        this.lines = lines;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
