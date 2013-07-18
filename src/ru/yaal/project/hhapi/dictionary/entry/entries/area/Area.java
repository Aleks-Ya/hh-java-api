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
    public static final Area MOSCOW = Dictionaries.getArea().getEntryByName("Москва");
    public static final Area SAINT_PETERSBURG = Dictionaries.getArea().getEntryByName("Санкт-Петербург");
    @Getter
    @Setter
    private Area parent;
    @Getter
    @Setter
    private URL url;
    @Getter
    @Setter
    private IDictionary<Area> areas;

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.AREA, getId());
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Area) {
            Area otherArea = (Area) other;
            return (getId().equals(otherArea.getId()));
        } else {
            return false;
        }
    }
}
