package ru.yaal.project.hhapi.loader.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FileStorageTest {
    private ICache storage;
    private File tempFile;

    @Before
    public void before() {
        tempFile = new File(System.getProperty(ContentLoaderFactory.JAVA_IO_TMPDIR) + "test_hh_api_cache\\");
    }

    @Test
    public void testSave() throws Exception {
        int lifeTime = 10000;
        storage = new FileCache(tempFile, lifeTime);
        storage.clear();
        final String name = "http://ready.com/now?fuck=true";
        assertNull(storage.search(name));
        final String expContent = "{girl:777}";
        storage.save(name, expContent);
        String actContent = storage.search(name);
        assertEquals(expContent, actContent);
    }

    @Test
    public void outdated() throws Exception {
        int lifeTimeMin = 0;
        storage = new FileCache(tempFile, lifeTimeMin);
        storage.clear();
        ICache storage = new MemoryCache(lifeTimeMin);
        String name = "http://gangalee.net";
        String content = "{Dancehall Tune:'Vybz Kartel'}";
        storage.save(name, content);
        Thread.sleep(100);
        String actContent = storage.search(name);
        assertNull(actContent);
    }

    @After
    public void after() {
        storage.clear();
    }
}
