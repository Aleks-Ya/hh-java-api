package ru.yaal.project.hhapi.loader.storage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MemoryStorageTest {
    @Test
    public void testSave() throws Exception {
        int lifeTimeMin = 0;
        IStorage storage = new MemoryStorage(lifeTimeMin);
        String name = "http://nasa.com?curiosity=good";

        assertNull(storage.search(name));

        String expectedContent = "{gangnamStyle:PSY}";
        storage.save(name, expectedContent);
        String actualContent = storage.search(name);
        assertEquals(expectedContent, actualContent);

        storage.delete(name);
        assertNull(storage.search(name));

        storage.save(name, expectedContent);
        storage.clear();
        assertNull(storage.search(name));
    }

    @Test
    public void outdated() throws Exception {
        int lifeTimeMin = 0;
        IStorage storage = new MemoryStorage(lifeTimeMin);
        String name = "http://danceja.com";
        String content = "{Dancehall:'Vybz Kartel'}";
        storage.save(name, content);
        Thread.sleep(100);
        String actualContent = storage.search(name);
        assertNull(actualContent);
    }
}
