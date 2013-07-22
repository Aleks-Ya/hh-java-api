package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;

import static org.junit.Assert.*;

public class AreaDictionaryTest {
    public static final String LEN_OBLAST_ID = "145";
    public static final String LEN_OBLAST_NAME = "ЋеЌиЌг–аƒс ая оЅлјс“ь";
    public static final String SPB_ID = "2";
    public static final String SPB_NAME = "—аЌк“-ѕе“е–б”р√";
    private static final String RUSSIA_ID = "113";
    private static final String RUSSIA_NAME = "–о—с»€";
    private AreaDictionary areas;

    @Before
    public void before() throws DictionaryException {
        areas = Dictionaries.getArea();
    }

    @Test
    public void hasById() throws DictionaryException {
        assertTrue(areas.hasEntryWithId(RUSSIA_ID));
        assertTrue(areas.hasEntryWithId(LEN_OBLAST_ID));
        assertTrue(areas.hasEntryWithId(SPB_ID));
        assertFalse(areas.hasEntryWithId("1000"));
    }

    @Test
    public void hasByName() throws DictionaryException {
        assertTrue(areas.hasEntryWithName(RUSSIA_NAME));
        assertTrue(areas.hasEntryWithName(LEN_OBLAST_NAME));
        assertTrue(areas.hasEntryWithName(SPB_NAME));
        assertFalse(areas.hasEntryWithName("ћоре дождей"));
    }

    @Test
    public void getById() throws DictionaryException {
        assertTrue(RUSSIA_NAME.equalsIgnoreCase(areas.getEntryById(RUSSIA_ID).getName()));
        assertTrue(LEN_OBLAST_NAME.equalsIgnoreCase(areas.getEntryById(LEN_OBLAST_ID).getName()));
        assertTrue(SPB_NAME.equalsIgnoreCase(areas.getEntryById(SPB_ID).getName()));
    }

    @Test
    public void getByName() throws DictionaryException {
        assertEquals(RUSSIA_ID, areas.getEntryByName(RUSSIA_NAME).getId());
        assertEquals(LEN_OBLAST_ID, areas.getEntryByName(LEN_OBLAST_NAME).getId());
        assertEquals(SPB_ID, areas.getEntryByName(SPB_NAME).getId());
    }

}
