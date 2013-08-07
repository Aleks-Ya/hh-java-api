package ru.yaal.project.hhapi.loader;

import ru.yaal.project.hhapi.search.SearchException;

public interface IContentLoader {
    String loadContent(final String url) throws SearchException;

    void addHeader(String key, String value);

    void addParam(String key, String value);
}
