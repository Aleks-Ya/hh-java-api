package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MetroCity extends AbstractDictionaryEntry implements ISearchParameter {
    public static final MetroCity NULL_METRO_CITY = new MetroCity();
    @Getter
    @Setter
    private URL url;
    @Getter
    @Setter
    private IDictionary<MetroLine> lines = new Dictionary<>();

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.METRO, getId());
        return params;
    }
}
