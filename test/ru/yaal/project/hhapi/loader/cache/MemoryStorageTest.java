package ru.yaal.project.hhapi.loader.cache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MemoryStorageTest {
    @Test
    public void testSave() throws Exception {
        int lifeTimeMin = 10;
        ICache storage = new MemoryCache(lifeTimeMin);
        String name = "http://nasa.com?curiosity=good";

        assertNull(storage.search(name));

        String expContent = "{gangnamStyle:PSY}";
        storage.save(name, expContent);
        String actContent = storage.search(name);
        assertEquals(expContent, actContent);

        storage.delete(name);
        assertNull(storage.search(name));

        storage.save(name, expContent);
        storage.clear();
        assertNull(storage.search(name));
    }

    @Test
    public void outdated() throws Exception {
        int lifeTimeMin = 0;
        ICache storage = new MemoryCache(lifeTimeMin);
        String name = "http://danceja.com";
        String content = "{Dancehall:'Vybz Kartel'}";
        storage.save(name, content);
        Thread.sleep(100);
        String actContent = storage.search(name);
        assertNull(actContent);
    }
}
