package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries2;
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
        metroCityDictionary = Dictionaries2.getInstance().getMetroCities();
    }

    @Test
    public void getById() throws DictionaryException {
        MetroCity city = metroCityDictionary.getById(CITY_ID_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));

        MetroLine line = (MetroLine) metroCityDictionary.getById(LINE_ID_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) metroCityDictionary.getById(STATION_ID_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void getByName() throws DictionaryException {
        MetroCity city = metroCityDictionary.getByName(CITY_NAME_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));

        MetroLine line = (MetroLine) metroCityDictionary.getByName(LINE_NAME_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) metroCityDictionary.getByName(STATION_NAME_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void hasWithId() throws DictionaryException {
        assertTrue(metroCityDictionary.hasId(CITY_ID_MOSCOW));
        assertTrue(metroCityDictionary.hasId(LINE_ID_CENTRALNO_ZAVODSKAYA));
        assertTrue(metroCityDictionary.hasId(STATION_ID_NOVOSLABODSKAYA));
        assertFalse(metroCityDictionary.hasId("1000"));
    }

    @Test
    public void hasCityWithName() throws DictionaryException {
        assertTrue(metroCityDictionary.hasName(CITY_NAME_MOSCOW));
        assertTrue(metroCityDictionary.hasName(LINE_NAME_CENTRALNO_ZAVODSKAYA));
        assertTrue(metroCityDictionary.hasName(STATION_NAME_NOVOSLABODSKAYA));
        assertFalse(metroCityDictionary.hasName("”˛ÔËÌÒÍ"));
    }
}