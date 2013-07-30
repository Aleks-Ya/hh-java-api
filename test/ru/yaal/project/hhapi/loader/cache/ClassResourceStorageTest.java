package ru.yaal.project.hhapi.loader.cache;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class ClassResourceStorageTest {
    @Test
    public void search() {
        ICache storage = new ClassResourceCache(
                new File(System.getProperty(ContentLoaderFactory.JAVA_IO_TMPDIR) + "test_hh_api_cache\\test\\"));
        String content = storage.search(UrlConstants.DICTINARIES_URL);
        assertTrue(content.length() > 100);
    }
}
