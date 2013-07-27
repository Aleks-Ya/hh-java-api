package ru.yaal.project.hhapi.loader.storage;

import java.io.File;
import java.net.URL;

public class ClassResourceStorage extends AbstractStorage {

    public ClassResourceStorage() {
        super(1000);
    }

    @Override
    public String search(String name) {
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
        //не используется
    }

    @Override
    public void delete(String name) {
        //не используется
    }

    @Override
    public void clear() {
        //не используется
    }
}
