package ru.yaal.project.hhapi.loader.cache.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FileStorageTest {
    private IStorage storage;

    @Before
    public void before() {
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "test_hh_api_cache\\");
        int lifeTime = 10000;
        storage = new FileStorage(tempFile, lifeTime);
        storage.clear();
    }

    @Test
    public void testSave() throws Exception {
        final String name = "http://ready.com/now?fuck=true";
        String nullContent = storage.search(name);
        assertNull(nullContent);
        final String expectedContent = "{girl:777}";
        storage.save(name, expectedContent);
        String actualContent = storage.search(name);
        assertEquals(expectedContent, actualContent);
    }

    @After
    public void after() {
        storage.clear();
    }
}
