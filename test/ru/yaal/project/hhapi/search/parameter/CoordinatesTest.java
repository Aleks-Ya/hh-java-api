package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Address;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CoordinatesTest {

    @Test
    public void testCoordinates() throws SearchException, DictionaryException {
        double latTop = 59.932243;
        double latBottom = 59.915611;
        double lngLeft = 30.303541;
        double lngRight = 30.360532;
        double inaccuracy = 0.01;
        Coordinates coordinates = new Coordinates(latTop, latBottom, lngLeft, lngRight);
        for (Vacancy vacancy : HhApi.search(200, coordinates)) {
            Address address = vacancy.getAddress();
            String city = address.getCity();
            if (city != null) {
                assertTrue(city.startsWith("Санкт-Петербург"));
            }
            MetroStation station = address.getStation();
            if (station != null) {
                Double lat = station.getLat();
                Double lng = station.getLng();
                if (lat != null) {
                    assertThat(lat, allOf(greaterThan(latBottom - inaccuracy), lessThan(latTop + inaccuracy)));
                }
                if (lng != null) {
                    assertThat(lng, allOf(greaterThan(lngLeft - inaccuracy), lessThan(lngRight + inaccuracy)));
                }
            }
        }
    }

}
