package ru.yaal.project.hhapi.loader.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FileStorageTest {
    private ICache storage;
    private File tempFile;

    @Before
    public void before() {
        tempFile = new File(System.getProperty("java.io.tmpdir") + "test_hh_api_cache\\");
    }

    @Test
    public void testSave() throws Exception {
        int lifeTime = 10000;
        storage = new FileCache(tempFile, lifeTime);
        storage.clear();
        final String name = "http://ready.com/now?fuck=true";
        assertNull(storage.search(name));
        final String expectedContent = "{girl:777}";
        storage.save(name, expectedContent);
        String actualContent = storage.search(name);
        assertEquals(expectedContent, actualContent);
    }

    @Test
    public void outdated() throws Exception {
        int lifeTimeMin = 0;
        storage = new FileCache(tempFile, lifeTimeMin);
        storage.clear();
        ICache storage = new MemoryCache(lifeTimeMin);
        String name = "http://danceja.com";
        String content = "{Dancehall:'Vybz Kartel'}";
        storage.save(name, content);
        Thread.sleep(100);
        String actualContent = storage.search(name);
        assertNull(actualContent);
    }

    @After
    public void after() {
        storage.clear();
    }
}
