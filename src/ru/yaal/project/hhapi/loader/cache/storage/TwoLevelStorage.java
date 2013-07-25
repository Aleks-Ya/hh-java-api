package ru.yaal.project.hhapi.loader.cache.storage;

public class TwoLevelStorage implements IStorage {
    private IStorage fastStorage;
    private IStorage slowStorage;

    public TwoLevelStorage(IStorage fastStorage, IStorage slowStorage) {
        this.fastStorage = fastStorage;
        this.slowStorage = slowStorage;
    }

    @Override
    public String search(String name) {
        String content = fastStorage.search(name);
        if (content == null) {
            content = slowStorage.search(name);
            if (content != null) {
                fastStorage.save(name, content);
            }
        }
        return content;
    }

    @Override
    public void save(String name, String content) {
        fastStorage.save(name, content);
        slowStorage.save(name, content);
    }

    @Override
    public void delete(String name) {
        fastStorage.delete(name);
        slowStorage.delete(name);
    }

    @Override
    public void clear() {
        fastStorage.clear();
        slowStorage.clear();
    }
}
