package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

import java.net.URL;

public class Area extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Area NULL_AREA = new Area();
    public static final AreaDictionary AREAS = Dictionaries.getInstance().getAreas();
    public static final Area MOSCOW = AREAS.getByName("Москва");
    public static final Area SAINT_PETERSBURG = AREAS.getByName("Санкт-Петербург");
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Area parent;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL url;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Area> areas;

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.AREA, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Регион";
    }

}
