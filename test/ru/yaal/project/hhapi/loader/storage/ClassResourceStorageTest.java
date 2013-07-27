package ru.yaal.project.hhapi.loader.storage;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.UrlConstants;

import static org.junit.Assert.assertTrue;

public class ClassResourceStorageTest {
    @Test
    public void search() {
        IStorage storage = new ClassResourceStorage();
        String content = storage.search(UrlConstants.DICTINARIES_URL);
        assertTrue(content.length() > 100);
    }
}
