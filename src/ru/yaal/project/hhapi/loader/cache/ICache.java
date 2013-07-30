package ru.yaal.project.hhapi.loader.cache;

public interface ICache {
    String search(String name);

    void save(String name, String content);

    void delete(String name);

    void clear();

    String getCacheName();
}
