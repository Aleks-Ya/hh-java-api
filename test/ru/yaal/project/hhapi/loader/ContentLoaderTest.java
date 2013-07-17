package ru.yaal.project.hhapi.loader;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ContentLoaderTest {
    @Test
    public void testLoadContent() throws Exception {
        IContentLoader loader = new ContentLoader();
        String content = loader.loadContent(UrlConstants.DICTINARIES_URL);
        assertNotNull(content);
        assertTrue(content.contains("currency"));
    }

}
