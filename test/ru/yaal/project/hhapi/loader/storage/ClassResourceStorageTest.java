package ru.yaal.project.hhapi.loader.storage;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.UrlConstants;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class ClassResourceStorageTest {
    @Test
    public void search() {
        IStorage storage = new ClassResourceStorage(new File(System.getProperty("java.io.tmpdir") + "test_hh_api_cache\\test\\"));
        String content = storage.search(UrlConstants.DICTINARIES_URL);
        assertTrue(content.length() > 100);
    }
}
