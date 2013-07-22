package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MetroCityDictionaryTest {
    public static final String CITY_NAME_MOSCOW = "ÃÓ—Í¬‡";
    public static final String CITY_ID_MOSCOW = "1";
    public static final String LINE_ID_CENTRALNO_ZAVODSKAYA = "58";
    public static final String LINE_NAME_CENTRALNO_ZAVODSKAYA = "÷ÂÕÚ–‡À¸ÕÓ-«‡¬ÓƒÒ ‡ﬂ";
    public static final String STATION_ID_NOVOSLABODSKAYA = "5.82";
    public static final String STATION_NAME_NOVOSLABODSKAYA = "ÕÓ¬Ó—ÎŒ·Œ‰—Í¿ˇ";
    private MetroCityDictionary metroCityDictionary;

    @Before
    public void before() throws DictionaryException {
        metroCityDictionary = Dictionaries.getMetro();
    }

    @Test
    public void getById() throws DictionaryException {
        MetroCity city = metroCityDictionary.getEntryById(CITY_ID_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));

        MetroLine line = (MetroLine) metroCityDictionary.getEntryById(LINE_ID_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) metroCityDictionary.getEntryById(STATION_ID_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void getByName() throws DictionaryException {
        MetroCity city = metroCityDictionary.getEntryByName(CITY_NAME_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));

        MetroLine line = (MetroLine) metroCityDictionary.getEntryByName(LINE_NAME_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) metroCityDictionary.getEntryByName(STATION_NAME_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void hasWithId() throws DictionaryException {
        assertTrue(metroCityDictionary.hasEntryWithId(CITY_ID_MOSCOW));
        assertTrue(metroCityDictionary.hasEntryWithId(LINE_ID_CENTRALNO_ZAVODSKAYA));
        assertTrue(metroCityDictionary.hasEntryWithId(STATION_ID_NOVOSLABODSKAYA));
        assertFalse(metroCityDictionary.hasEntryWithId("1000"));
    }

    @Test
    public void hasCityWithName() throws DictionaryException {
        assertTrue(metroCityDictionary.hasEntryWithName(CITY_NAME_MOSCOW));
        assertTrue(metroCityDictionary.hasEntryWithName(LINE_NAME_CENTRALNO_ZAVODSKAYA));
        assertTrue(metroCityDictionary.hasEntryWithName(STATION_NAME_NOVOSLABODSKAYA));
        assertFalse(metroCityDictionary.hasEntryWithName("”˛ÔËÌÒÍ"));
    }
}