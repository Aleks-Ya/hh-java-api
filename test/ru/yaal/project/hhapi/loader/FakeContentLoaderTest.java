package ru.yaal.project.hhapi.loader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FakeContentLoader.class)
public class FakeContentLoaderTest {

    @Test
    public void usage() throws Exception {
        IContentLoader loader = new FakeContentLoader();
        String content = loader.loadContent("https://no.exists.com/vacancies?text=java");
        assertEquals("Тестовый файл для проверки CacheDriver. Плиз не удалять!", content);
    }
}
