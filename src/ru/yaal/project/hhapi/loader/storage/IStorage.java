package ru.yaal.project.hhapi.loader.storage;

public interface IStorage {
    String search(String name);

    void save(String name, String content);

    void delete(String name);

    void clear();
}
