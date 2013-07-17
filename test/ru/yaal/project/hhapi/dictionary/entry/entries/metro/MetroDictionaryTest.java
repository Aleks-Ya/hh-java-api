package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MetroDictionaryTest {
    public static final String CITY_NAME_MOSCOW = "ÃÓ—Í¬‡";
    public static final String CITY_ID_MOSCOW = "1";
    public static final String LINE_ID_CENTRALNO_ZAVODSKAYA = "58";
    public static final String LINE_NAME_CENTRALNO_ZAVODSKAYA = "÷ÂÕÚ–‡À¸ÕÓ-«‡¬ÓƒÒ ‡ﬂ";
    public static final String STATION_ID_NOVOSLABODSKAYA = "5.82";
    public static final String STATION_NAME_NOVOSLABODSKAYA = "ÕÓ¬Ó—ÎŒ·Œ‰—Í¿ˇ";
    private MetroDictionary metroDictionary;

    @BeforeClass
    public static void beforeClass() throws DictionaryException {
        Dictionaries.setLoader(new FakeContentLoader());
    }

    @Before
    public void before() throws DictionaryException {
        metroDictionary = Dictionaries.getMetro();
    }

    @Test
    public void getById() throws DictionaryException {
        MetroCity city = metroDictionary.getEntryById(CITY_ID_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));

        MetroLine line = (MetroLine) metroDictionary.getEntryById(LINE_ID_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) metroDictionary.getEntryById(STATION_ID_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void getByName() throws DictionaryException {
        MetroCity city = metroDictionary.getEntryByName(CITY_NAME_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));

        MetroLine line = (MetroLine) metroDictionary.getEntryByName(LINE_NAME_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) metroDictionary.getEntryByName(STATION_NAME_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void hasWithId() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithId(CITY_ID_MOSCOW));
        assertTrue(metroDictionary.hasEntryWithId(LINE_ID_CENTRALNO_ZAVODSKAYA));
        assertTrue(metroDictionary.hasEntryWithId(STATION_ID_NOVOSLABODSKAYA));
        assertFalse(metroDictionary.hasEntryWithId("1000"));
    }

    @Test
    public void hasCityWithName() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithName(CITY_NAME_MOSCOW));
        assertTrue(metroDictionary.hasEntryWithName(LINE_NAME_CENTRALNO_ZAVODSKAYA));
        assertTrue(metroDictionary.hasEntryWithName(STATION_NAME_NOVOSLABODSKAYA));
        assertFalse(metroDictionary.hasEntryWithName("”˛ÔËÌÒÍ"));
    }
}