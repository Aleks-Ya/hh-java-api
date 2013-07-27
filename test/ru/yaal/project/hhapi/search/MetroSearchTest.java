package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation;
import ru.yaal.project.hhapi.vacancy.Address;
import ru.yaal.project.hhapi.vacancy.Metro;
import ru.yaal.project.hhapi.vacancy.Vacancy;
import ru.yaal.project.hhapi.vacancy.VacancyList;

import static org.junit.Assert.assertTrue;
import static ru.yaal.project.hhapi.search.VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT;

public class MetroSearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void testMetro() throws SearchException, DictionaryException {
        MetroStation metroExpected = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Площадь Восстания");
        MetroStation metroExpected2 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Маяковская");
        MetroStation metroExpected3 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Чернышевская");
        search.addParameter(metroExpected);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(1 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                Metro metroActual = address.getMetro();
                if (!metroActual.isNull()) {
                    MetroStation metroStationActual = (MetroStation) MetroLine.SAINT_PETERSBURG.getById(metroActual.getMetroId());
                    assertTrue(metroStationActual.equals(metroExpected)
                            || metroStationActual.equals(metroExpected2)
                            || metroStationActual.equals(metroExpected3));
                }
            }
        }
    }
}
