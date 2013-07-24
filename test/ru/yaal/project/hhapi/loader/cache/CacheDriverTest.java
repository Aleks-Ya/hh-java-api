package ru.yaal.project.hhapi.loader.cache;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.LoadException;

import static org.junit.Assert.assertEquals;

public class CacheDriverTest {
    @Test
    public void usage() throws LoadException {
        CacheDriver driver = new CacheDriver();
        driver.clearTempCache();
        final String url1 = "https://yablokov.ura.com/servlet?a=b&ya=al";
        final String text1 = "Привет от Мазилы Барабашкина1";
        final String url2 = "https://yablokov.ura.com/servlet?a=b&ya=al?newText=true";
        final String text2 = "Никогда не рано отказаться от борьбы!!!!";
        driver.saveContent(url1, text1);
        driver.saveContent(url2, text2);
        String loaded1 = driver.searchContent(url1);
        assertEquals(text1, loaded1);
        String loaded2 = driver.searchContent(url2);
        assertEquals(text2, loaded2);
    }

    @Test
    public void rewrite() throws LoadException {
        CacheDriver driver = new CacheDriver();
        driver.clearTempCache();
        final String url = "https://hh.api.com/servlet?text=java";
        final String text1 = "Ищем java-разработчиков";
        final String text2 = "Java is the best!";
        driver.saveContent(url, text1);
        String loaded1 = driver.searchContent(url);
        assertEquals(text1, loaded1);
        driver.saveContent(url, text2);
        String loaded2 = driver.searchContent(url);
        assertEquals(text2, loaded2);
    }

    @Test
    public void readFromProjectCache() throws LoadException {
        CacheDriver driver = new CacheDriver();
        driver.clearTempCache();
        final String url = "https://hh.api.com/vacancies?text=java";
        final String text = "Java is the best programming language!!!";
        String loaded = driver.searchContent(url);
        assertEquals(text, loaded);
    }
}
