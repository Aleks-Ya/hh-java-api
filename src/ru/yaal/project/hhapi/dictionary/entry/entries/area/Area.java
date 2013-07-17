package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Area extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Area NULL_AREA = new Area();
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
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.AREA, getId());
        return params;
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
