package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;


public class MetroLine extends AbstractDictionaryEntry implements ISearchParameter {
    public static final MetroLine NULL_METRO_LINE = new MetroLine();
    public static final MetroLineDictionary MOSCOW = Dictionaries.getInstance().getMetroCities().getByName("Москва").getLines();
    public static final MetroLineDictionary SAINT_PETERSBURG = Dictionaries.getInstance().getMetroCities().getByName("Санкт-Петербург").getLines();
    public static final MetroLineDictionary KHARKOV = Dictionaries.getInstance().getMetroCities().getByName("Харьков").getLines();
    public static final MetroLineDictionary KAZAN = Dictionaries.getInstance().getMetroCities().getByName("Казань").getLines();
    public static final MetroLineDictionary DNEPROPETROVSK = Dictionaries.getInstance().getMetroCities().getByName("Днепропетровск").getLines();
    public static final MetroLineDictionary KIEV = Dictionaries.getInstance().getMetroCities().getByName("Киев").getLines();
    public static final MetroLineDictionary EKATERINGURG = Dictionaries.getInstance().getMetroCities().getByName("Екатеринбург").getLines();
    public static final MetroLineDictionary NOVOSIBIRSK = Dictionaries.getInstance().getMetroCities().getByName("Новосибирск").getLines();
    public static final MetroLineDictionary NIZHNI_NOVGOROD = Dictionaries.getInstance().getMetroCities().getByName("Нижний Новгород").getLines();
    public static final MetroLineDictionary ALMATY = Dictionaries.getInstance().getMetroCities().getByName("Алматы").getLines();
    public static final MetroLineDictionary MINSK = Dictionaries.getInstance().getMetroCities().getByName("Минск").getLines();
    public static final MetroLineDictionary SAMARA = Dictionaries.getInstance().getMetroCities().getByName("Самара").getLines();
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String hexColor;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<MetroStation> stations;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private MetroCity city;

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.METRO, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Линия метро";
    }
}
