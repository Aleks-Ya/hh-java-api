package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.net.URL;

public class MetroCity extends AbstractDictionaryEntry {
    public static final MetroCity NULL_METRO_CITY = new MetroCity();
    public static final MetroCity MOSCOW = Dictionaries.getMetro().getByName("Москва");
    public static final MetroCity SAINT_PETERSBURG = Dictionaries.getMetro().getByName("Санкт-Петербург");
    public static final MetroCity KHARKOV = Dictionaries.getMetro().getByName("Харьков");
    public static final MetroCity KAZAN = Dictionaries.getMetro().getByName("Казань");
    public static final MetroCity DNEPROPETROVSK = Dictionaries.getMetro().getByName("Днепропетровск");
    public static final MetroCity KIEV = Dictionaries.getMetro().getByName("Киев");
    public static final MetroCity EKATERINGURG = Dictionaries.getMetro().getByName("Екатеринбург");
    public static final MetroCity NOVOSIBIRSK = Dictionaries.getMetro().getByName("Новосибирск");
    public static final MetroCity NIZHNI_NOVGOROD = Dictionaries.getMetro().getByName("Нижний Новгород");
    public static final MetroCity ALMATY = Dictionaries.getMetro().getByName("Алматы");
    public static final MetroCity MINSK = Dictionaries.getMetro().getByName("Минск");
    public static final MetroCity SAMARA = Dictionaries.getMetro().getByName("Самара");
    @Getter
    @Setter
    private URL url;
    @Getter
    @Setter
    private MetroLineDictionary lines = new MetroLineDictionary();
}
