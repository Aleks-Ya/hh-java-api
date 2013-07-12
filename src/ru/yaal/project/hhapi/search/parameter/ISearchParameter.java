package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.SearchException;

import java.util.Map;

public interface ISearchParameter {
    Map<SearchParamNames, String> getSearchParameters() throws SearchException;
}
