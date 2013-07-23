package ru.yaal.project.hhapi.loader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FakeContentLoader.class, ContentLoader.class})
public class FakeContentLoaderTest {
    @Test
    public void usage() throws Exception {
        IContentLoader loader = spy(new FakeContentLoader());
        String content = loader.loadContent(UrlConstants.DICTINARIES_URL);
        assertTrue(content.length() > 100);
        verifyPrivate(loader, times(0)).invoke("loadFromNet", anyString());
    }
}
