package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.*;

public class MetroCityDictionaryTest {
    public static final String CITY_NAME_MOSCOW = "ÌîÑêÂà";
    public static final String CITY_ID_MOSCOW = "1";
    private MetroCityDictionary metroCityDictionary;

    @Before
    public void before() {
        metroCityDictionary = MetroCity.CITIES;
    }

    @Test
    public void getById() {
        MetroCity city = metroCityDictionary.getById(CITY_ID_MOSCOW);
        assertThat(CITY_NAME_MOSCOW, equalToIgnoringCase(city.getName()));
    }

    @Test
    public void getByName() {
        MetroCity city = metroCityDictionary.getByName(CITY_NAME_MOSCOW);
        assertThat(CITY_NAME_MOSCOW, equalToIgnoringCase(city.getName()));
    }

    @Test
    public void hasWithId() {
        assertTrue(metroCityDictionary.hasId(CITY_ID_MOSCOW));
        assertFalse(metroCityDictionary.hasId("1000"));
    }

    @Test
    public void hasCityWithName() {
        assertTrue(metroCityDictionary.hasName(CITY_NAME_MOSCOW));
        assertFalse(metroCityDictionary.hasName("Óðþïèíñê"));
    }
}