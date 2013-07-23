package ru.yaal.project.hhapi.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentLoaderFactory {
    private static final Logger LOG = LoggerFactory.getLogger(ContentLoaderFactory.class);

    public static IContentLoader newInstance() {
        String fakeContentLoaderName = System.getProperty("content_loader");
        if (fakeContentLoaderName != null) {
            try {
                Class fakeContentLoaderClass = Class.forName(fakeContentLoaderName);
                return (IContentLoader) fakeContentLoaderClass.newInstance();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return new ContentLoader();
    }
}
