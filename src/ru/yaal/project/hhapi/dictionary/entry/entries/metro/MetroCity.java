package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.net.URL;

public class MetroCity extends AbstractDictionaryEntry {
    public static final MetroCity NULL_METRO_CITY = new MetroCity();
    public static final MetroCity MOSCOW = Dictionaries.getMetro().getByName("������");
    public static final MetroCity SAINT_PETERSBURG = Dictionaries.getMetro().getByName("�����-���������");
    public static final MetroCity KHARKOV = Dictionaries.getMetro().getByName("�������");
    public static final MetroCity KAZAN = Dictionaries.getMetro().getByName("������");
    public static final MetroCity DNEPROPETROVSK = Dictionaries.getMetro().getByName("��������������");
    public static final MetroCity KIEV = Dictionaries.getMetro().getByName("����");
    public static final MetroCity EKATERINGURG = Dictionaries.getMetro().getByName("������������");
    public static final MetroCity NOVOSIBIRSK = Dictionaries.getMetro().getByName("�����������");
    public static final MetroCity NIZHNI_NOVGOROD = Dictionaries.getMetro().getByName("������ ��������");
    public static final MetroCity ALMATY = Dictionaries.getMetro().getByName("������");
    public static final MetroCity MINSK = Dictionaries.getMetro().getByName("�����");
    public static final MetroCity SAMARA = Dictionaries.getMetro().getByName("������");
    @Getter
    @Setter
    private URL url;
    @Getter
    @Setter
    private MetroLineDictionary lines = new MetroLineDictionary();
}
