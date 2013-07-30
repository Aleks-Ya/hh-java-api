package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.SearchException;

public interface ISearchParameter {
    SearchParameterBox getSearchParameters() throws SearchException;

    String getSearchParameterName();
}
