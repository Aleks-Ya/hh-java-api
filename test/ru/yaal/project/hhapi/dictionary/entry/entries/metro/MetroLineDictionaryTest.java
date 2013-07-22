package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MetroLineDictionaryTest {
    public static final String LINE_ID = "15";
    public static final String LINE_NAME = "Московско-Петроградская";
    public static final String STATION_ID = "14.199";
    public static final String STATION_NAME = "Площадь Восстания";
    private MetroLineDictionary dictionary;

    @Before
    public void before() throws DictionaryException {
        dictionary = MetroCity.SAINT_PETERSBURG.getLines();
    }

    @Test
    public void getById() throws DictionaryException {
        MetroLine line = dictionary.getEntryById(LINE_ID);
        assertTrue(LINE_NAME.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) dictionary.getEntryById(STATION_ID);
        assertTrue(STATION_NAME.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void getByName() throws DictionaryException {
        MetroLine line = dictionary.getEntryByName(LINE_NAME);
        assertTrue(LINE_NAME.equalsIgnoreCase(line.getName()));

        MetroStation station = (MetroStation) dictionary.getEntryByName(STATION_NAME);
        assertTrue(STATION_NAME.equalsIgnoreCase(station.getName()));
    }

    @Test
    public void hasWithId() throws DictionaryException {
        assertTrue(dictionary.hasEntryWithId(LINE_ID));
        assertTrue(dictionary.hasEntryWithId(STATION_ID));
        assertFalse(dictionary.hasEntryWithId("1000"));
    }

    @Test
    public void hasCityWithName() throws DictionaryException {
        assertTrue(dictionary.hasEntryWithName(LINE_NAME));
        assertTrue(dictionary.hasEntryWithName(STATION_NAME));
        assertFalse(dictionary.hasEntryWithName("Урюпинск"));
    }
}
