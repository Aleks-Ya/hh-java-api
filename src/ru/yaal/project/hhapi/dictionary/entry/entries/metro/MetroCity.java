package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionaries2;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.net.URL;

public class MetroCity extends AbstractDictionaryEntry {
    public static final MetroCity NULL_METRO_CITY = new MetroCity();
    public static final MetroCity MOSCOW = Dictionaries2.getInstance().getMetroCities().getByName("Москва");
    public static final MetroCity SAINT_PETERSBURG = Dictionaries2.getInstance().getMetroCities().getByName("Санкт-Петербург");
    public static final MetroCity KHARKOV = Dictionaries2.getInstance().getMetroCities().getByName("Харьков");
    public static final MetroCity KAZAN = Dictionaries2.getInstance().getMetroCities().getByName("Казань");
    public static final MetroCity DNEPROPETROVSK = Dictionaries2.getInstance().getMetroCities().getByName("Днепропетровск");
    public static final MetroCity KIEV = Dictionaries2.getInstance().getMetroCities().getByName("Киев");
    public static final MetroCity EKATERINGURG = Dictionaries2.getInstance().getMetroCities().getByName("Екатеринбург");
    public static final MetroCity NOVOSIBIRSK = Dictionaries2.getInstance().getMetroCities().getByName("Новосибирск");
    public static final MetroCity NIZHNI_NOVGOROD = Dictionaries2.getInstance().getMetroCities().getByName("Нижний Новгород");
    public static final MetroCity ALMATY = Dictionaries2.getInstance().getMetroCities().getByName("Алматы");
    public static final MetroCity MINSK = Dictionaries2.getInstance().getMetroCities().getByName("Минск");
    public static final MetroCity SAMARA = Dictionaries2.getInstance().getMetroCities().getByName("Самара");
    @Getter
    @Setter
    private URL url;
    @Getter
    @Setter
    private MetroLineDictionary lines = new MetroLineDictionary();
}
