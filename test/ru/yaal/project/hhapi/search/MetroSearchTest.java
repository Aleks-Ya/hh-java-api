package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation;
import ru.yaal.project.hhapi.vacancy.Address;
import ru.yaal.project.hhapi.vacancy.Metro;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertTrue;
import static ru.yaal.project.hhapi.search.VacanciesSearchTest.WITHOUT_PARAMS_VACANCIES_COUNT;

public class MetroSearchTest {
    private ISearch<VacancyList> search = new VacanciesSearch();

    @Test
    public void testMetro() throws SearchException, DictionaryException {
        MetroStation metroExpected = (MetroStation) MetroCity.SAINT_PETERSBURG.getLines().getEntryByName("Площадь Восстания");
        MetroStation metroExpected2 = (MetroStation) MetroCity.SAINT_PETERSBURG.getLines().getEntryByName("Маяковская");
        MetroStation metroExpected3 = (MetroStation) MetroCity.SAINT_PETERSBURG.getLines().getEntryByName("Чернышевская");
        search.addParameter(metroExpected);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(1 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                Metro metroActual = address.getMetro();
                if (!metroActual.isNull()) {
                    MetroStation metroStationActual = (MetroStation) MetroCity.SAINT_PETERSBURG.getLines().getEntryById(metroActual.getMetroId());
                    assertTrue(metroStationActual.equals(metroExpected)
                            || metroStationActual.equals(metroExpected2)
                            || metroStationActual.equals(metroExpected3));
                }
            }
        }
    }
}
