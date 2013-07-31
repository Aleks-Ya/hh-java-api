package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;

import static org.junit.Assert.assertTrue;

public class MetroSearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void testMetro() throws SearchException, DictionaryException {
        MetroStation metroExpected = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Площадь Восстания");
        MetroStation metroExpected2 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Маяковская");
        MetroStation metroExpected3 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Чернышевская");
        search.addParameter(metroExpected);
        VacancyList result = search.search();
        assertTrue(VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(1 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                Address.Station stationActual = address.getStation();
                if (!stationActual.isNull()) {
                    MetroStation metroStationActual = (MetroStation) MetroLine.SAINT_PETERSBURG.getById(stationActual.getStationId());
                    assertTrue(metroStationActual.equals(metroExpected)
                            || metroStationActual.equals(metroExpected2)
                            || metroStationActual.equals(metroExpected3));
                }
            }
        }
    }
}
