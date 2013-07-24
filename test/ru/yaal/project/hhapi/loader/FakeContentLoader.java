package ru.yaal.project.hhapi.loader;

import ru.yaal.project.hhapi.loader.cache.CacheDriver;

class FakeContentLoader extends ContentLoader {
    private final CacheDriver cacheDriver;

    FakeContentLoader() throws LoadException {
        cacheDriver = new CacheDriver();
    }

    @Override
    public String loadContent(String url) throws LoadException {
        String fromCache = cacheDriver.searchContent(appendParameters(url));
        if (fromCache != null) {
            return fromCache;
        } else {
            return loadFromNet(url);
        }
    }

    private String loadFromNet(String url) throws LoadException {
        String content = super.loadContent(url);
        cacheDriver.saveContent(appendParameters(url), content);
        return content;
    }
}
