package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class MetroCity extends AbstractDictionaryEntry implements ISearchParameter {
    private URL url;
    private List<MetroLine> lines;

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.METRO, getId());
        return params;
    }
}
