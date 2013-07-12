package ru.yaal.project.hhapi.search;

import ru.yaal.project.hhapi.search.parameter.ISearchParameter;


public interface ISearch<T> {
    T search() throws SearchException;

    /**
     * Можно строить цепочку параметров.
     */
    ISearch<T> addParameter(ISearchParameter param) throws SearchException;
}
