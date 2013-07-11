package ru.yaal.project.hhapi.loader;

import org.junit.Test;
import ru.yaal.project.hhapi.HhConstants;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ContentLoaderTest {
    @Test
    public void testLoadContent() throws Exception {
        IContentLoader loader = new ContentLoader();
        String content = loader.loadContent(HhConstants.DICTINARIES_URL);
        assertNotNull(content);
        assertTrue(content.contains("currency"));
    }

}
