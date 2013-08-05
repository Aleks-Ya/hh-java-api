package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation;
import ru.yaal.project.hhapi.search.SearchException;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MetroSearchTest {

    @Test
    public void testMetro() throws SearchException, DictionaryException {
        MetroStation metroExpected = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Площадь Восстания");
        MetroStation metroExpected2 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Маяковская");
        MetroStation metroExpected3 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Чернышевская");
        final int count = 30;
        IterableVacancyList vacancies = new IterableVacancySearch(30).addParameter(metroExpected).search();
        assertEquals(count, vacancies.size());
        for (Vacancy vacancy : vacancies) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                MetroStation stationActual = address.getStation();
                if (!stationActual.isNull()) {
                    assertThat(stationActual, isOneOf(metroExpected, metroExpected2, metroExpected3));
                }
            }
        }
    }
}
