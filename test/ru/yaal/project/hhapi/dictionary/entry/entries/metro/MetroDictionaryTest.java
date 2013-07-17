package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

import static org.junit.Assert.*;

public class MetroDictionaryTest {
    public static final String CITY_NAME_MOSCOW = "ÌîÑêÂà";
    public static final String CITY_ID_MOSCOW = "1";
    public static final String LINE_ID_CENTRALNO_ZAVODSKAYA = "58";
    public static final String LINE_NAME_CENTRALNO_ZAVODSKAYA = "ÖåÍòÐàËüÍî-ÇàÂîÄñÊàß";
    public static final String STATION_ID_NOVOSLABODSKAYA = "5.82";
    public static final String STATION_NAME_NOVOSLABODSKAYA = "ÍîÂîÑëÎáÎäÑêÀÿ";
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
    public void getCityById() throws DictionaryException {
        MetroCity city = metroDictionary.getEntryById(CITY_ID_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));
    }

    @Test
    public void getLineById() throws DictionaryException {
        MetroCity line = metroDictionary.getEntryById(LINE_ID_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));
    }

    @Test
    public void getStationById() throws DictionaryException {
        MetroCity station = metroDictionary.getEntryById(STATION_ID_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void getCityByName() throws DictionaryException {
        MetroCity city = metroDictionary.getEntryByName(CITY_NAME_MOSCOW);
        assertTrue(CITY_NAME_MOSCOW.equalsIgnoreCase(city.getName()));
    }

    @Test
    public void getLineByName() throws DictionaryException {
        MetroCity line = metroDictionary.getEntryByName(LINE_NAME_CENTRALNO_ZAVODSKAYA);
        assertTrue(LINE_NAME_CENTRALNO_ZAVODSKAYA.equalsIgnoreCase(line.getName()));
    }

    @Test
    public void getStationByName() throws DictionaryException {
        MetroCity station = metroDictionary.getEntryByName(STATION_NAME_NOVOSLABODSKAYA);
        assertTrue(STATION_NAME_NOVOSLABODSKAYA.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void hasCityWithId() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithId(CITY_ID_MOSCOW));
        assertFalse(metroDictionary.hasEntryWithId("1000"));
    }

    @Test
    public void hasLineWithId() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithId(LINE_ID_CENTRALNO_ZAVODSKAYA));
        assertFalse(metroDictionary.hasEntryWithId("1000"));
    }

    @Test
    public void hasStationWithId() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithId(STATION_ID_NOVOSLABODSKAYA));
        assertFalse(metroDictionary.hasEntryWithId("1000.82"));
    }

    @Test
    public void hasCityWithName() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithName(CITY_NAME_MOSCOW));
        assertFalse(metroDictionary.hasEntryWithName("Óðþïèíñê"));
    }

    @Test
    public void hasLineWithName() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithName(LINE_NAME_CENTRALNO_ZAVODSKAYA));
        assertFalse(metroDictionary.hasEntryWithName("Âåðõî-Íèæíÿÿ"));
    }

    @Test
    public void hasStationWithName() throws DictionaryException {
        assertTrue(metroDictionary.hasEntryWithName(STATION_NAME_NOVOSLABODSKAYA));
        assertFalse(metroDictionary.hasEntryWithName("Áóðæóéñêàÿ"));
    }
}
