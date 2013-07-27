package ru.yaal.project.hhapi.loader.storage;

import java.io.File;
import java.net.URL;

public class ClassResourceStorage extends AbstractStorage {
    private IStorage fileStorage;

    public ClassResourceStorage(File tempDir) {
        super(1000);
        fileStorage = new FileStorage(tempDir, 1000);
    }

    @Override
    public String search(String name) {
        String content = searchInResource(name);
        if (content == null) {
            content = fileStorage.search(name);
        }
        return content;
    }

    private String searchInResource(String name) {
        String hashName = generateHashFileName(name);
        URL resourceUrl = ClassResourceStorage.class.getResource(hashName);
        if (resourceUrl != null) {
            File resource = new File(resourceUrl.getFile());
            return loadFromFile(resource);
        } else {
            return null;
        }
    }

    @Override
    public void save(String name, String content) {
        fileStorage.save(name, content);
    }

    @Override
    public void delete(String name) {
        fileStorage.delete(name);
    }

    @Override
    public void clear() {
        fileStorage.clear();
    }
}
