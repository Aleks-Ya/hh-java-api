package ru.yaal.project.hhapi.loader;

public interface IContentLoader {
    String loadContent(final String url) throws LoadException;

    void addHeader(String key, String value);

    void addParam(String key, String value);
}
