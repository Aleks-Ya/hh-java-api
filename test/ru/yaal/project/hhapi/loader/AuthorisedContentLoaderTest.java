package ru.yaal.project.hhapi.loader;

import org.junit.Test;
import ru.yaal.project.hhapi.auth.Token;
import ru.yaal.project.hhapi.auth.TokenConstants;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AuthorisedContentLoaderTest {
    @Test
    public void testGood() throws LoadException {
        Token token = TokenConstants.YABLOKOV_TOKEN;
        IContentLoader loader = new AuthorisedContentLoader(token);
        String content = loader.loadContent(UrlConstants.ME_URL);
        assertNotNull(content);
        assertTrue(content.contains("яблоков"));
        System.out.println(content);
    }

    @Test(expected = LoadException.class)
    public void testWithoutToken() throws LoadException {
        IContentLoader loader = new ContentLoader();
        loader.loadContent(UrlConstants.ME_URL);
    }
}
