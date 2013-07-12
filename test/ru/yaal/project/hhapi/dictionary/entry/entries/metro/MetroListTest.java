package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

import static org.junit.Assert.assertEquals;

public class MetroListTest {
    @Test
    public void testFakeContentLoader() throws DictionaryException {
        Dictionaries.setLoader(new FakeContentLoader());
        MetroList metroList = Dictionaries.getMetro();
        MetroCity moscow = metroList.getEntryById("1");
        assertEquals("Москва", moscow.getName());
    }
}
