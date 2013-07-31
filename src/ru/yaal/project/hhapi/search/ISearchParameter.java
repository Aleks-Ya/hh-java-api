package ru.yaal.project.hhapi.search;

public interface ISearchParameter {
    SearchParameterBox getSearchParameters() throws SearchException;

    String getSearchParameterName();
}
