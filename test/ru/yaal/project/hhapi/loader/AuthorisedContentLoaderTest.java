package ru.yaal.project.hhapi.loader;

import org.junit.Test;
import ru.yaal.project.hhapi.HhConstants;
import ru.yaal.project.hhapi.HhToken;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AuthorisedContentLoaderTest {
    @Test
    public void test() throws LoadException {
        HhToken token = HhConstants.YABLOKOV_TOKEN;
        IContentLoader loader = new AuthorisedContentLoader(token);
        String content = loader.loadContent(HhConstants.ME_URL);
        assertNotNull(content);
        assertTrue(content.contains("�������"));
        System.out.println(content);
    }
}
