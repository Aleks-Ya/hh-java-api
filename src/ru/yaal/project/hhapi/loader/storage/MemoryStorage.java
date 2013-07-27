package ru.yaal.project.hhapi.loader.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MemoryStorage extends AbstractStorage {
    private static final Logger LOG = LoggerFactory.getLogger(MemoryStorage.class);
    private Map<String, StorageData> memoryCache = new HashMap<>();

    public MemoryStorage(int lifeTimeMin) {
        super(lifeTimeMin);
    }

    @Override
    public String search(String name) {
        String nameHash = generateHashFileName(name);
        StorageData content = memoryCache.get(nameHash);
        if (content != null) {
            return verifyContent(name, content.getContent(), content.getCreationDate());
        } else {
            return null;
        }
    }

    @Override
    public void save(String name, String content) {
        LOG.info(SAVE_DATA_MESSAGE, name, content.length());
        String nameHash = generateHashFileName(name);
        memoryCache.put(nameHash, new StorageData(content));
    }

    @Override
    public void delete(String name) {
        String nameHash = generateHashFileName(name);
        memoryCache.remove(nameHash);
    }

    @Override
    public void clear() {
        memoryCache.clear();
    }
}
