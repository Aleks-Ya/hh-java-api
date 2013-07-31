package ru.yaal.project.hhapi.search;


public interface ISearch<T> {
    T search() throws SearchException;

    /**
     * Можно строить цепочку параметров.
     */
    ISearch<T> addParameter(ISearchParameter parameter) throws SearchException;

    ISearch<T> addParameter(SearchParameterBox parameterBox) throws SearchException;
}
