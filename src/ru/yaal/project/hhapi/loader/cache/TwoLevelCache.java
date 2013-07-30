package ru.yaal.project.hhapi.loader.cache;

public class TwoLevelCache implements ICache {
    private ICache fastStorage;
    private ICache slowStorage;

    public TwoLevelCache(ICache fastStorage, ICache slowStorage) {
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

    @Override
    public String getCacheName() {
        return "Two Level Cache";
    }
}
