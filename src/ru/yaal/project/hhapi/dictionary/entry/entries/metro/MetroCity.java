package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.net.URL;

public class MetroCity extends AbstractDictionaryEntry {
    public static final MetroCity NULL_METRO_CITY = new MetroCity();
    public static final MetroCity MOSCOW = Dictionaries.getInstance().getMetroCities().getByName("������");
    public static final MetroCity SAINT_PETERSBURG = Dictionaries.getInstance().getMetroCities().getByName("�����-���������");
    public static final MetroCity KHARKOV = Dictionaries.getInstance().getMetroCities().getByName("�������");
    public static final MetroCity KAZAN = Dictionaries.getInstance().getMetroCities().getByName("������");
    public static final MetroCity DNEPROPETROVSK = Dictionaries.getInstance().getMetroCities().getByName("��������������");
    public static final MetroCity KIEV = Dictionaries.getInstance().getMetroCities().getByName("����");
    public static final MetroCity EKATERINGURG = Dictionaries.getInstance().getMetroCities().getByName("������������");
    public static final MetroCity NOVOSIBIRSK = Dictionaries.getInstance().getMetroCities().getByName("�����������");
    public static final MetroCity NIZHNI_NOVGOROD = Dictionaries.getInstance().getMetroCities().getByName("������ ��������");
    public static final MetroCity ALMATY = Dictionaries.getInstance().getMetroCities().getByName("������");
    public static final MetroCity MINSK = Dictionaries.getInstance().getMetroCities().getByName("�����");
    public static final MetroCity SAMARA = Dictionaries.getInstance().getMetroCities().getByName("������");
    @Getter
    @Setter
    private URL url;
    @Getter
    @Setter
    private MetroLineDictionary lines = new MetroLineDictionary();
}
