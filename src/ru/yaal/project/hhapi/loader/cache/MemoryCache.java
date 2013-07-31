package ru.yaal.project.hhapi.loader.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache extends AbstractCache {
    private static final Logger LOG = LoggerFactory.getLogger(MemoryCache.class);
    private static final String DEFAULT_NAME = "Memory Cache";
    private Map<String, CacheData> memoryCache = new HashMap<>();

    public MemoryCache(int lifeTimeMin) {
        this(DEFAULT_NAME, lifeTimeMin);
    }

    public MemoryCache(String name, int lifeTimeMin) {
        super(name, lifeTimeMin);
    }

    @Override
    public String search(String name) {
        String nameHash = generateHashFileName(name);
        CacheData content = memoryCache.get(nameHash);
        if (content != null) {
            return verifyContent(name, content.getContent(), content.getCreationDate());
        } else {
            return null;
        }
    }

    @Override
    public void save(String name, String content) {
        LOG.info(SAVE_DATA_MESSAGE, getCacheName(), name, content.length());
        String nameHash = generateHashFileName(name);
        memoryCache.put(nameHash, new CacheData(content));
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
