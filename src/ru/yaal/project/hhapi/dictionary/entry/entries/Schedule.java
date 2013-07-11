package ru.yaal.project.hhapi.dictionary.entry.entries;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.util.HashMap;
import java.util.Map;

public class Schedule extends AbstractDictionaryEntry implements ISearchParameter {
    @Override
    public Map<SearchParamNames, String> getSearchParameters() {
        Map<SearchParamNames, String> searchParams = new HashMap<>(1);
        searchParams.put(SearchParamNames.SCHEDULE, getId());
        return searchParams;
    }
}
