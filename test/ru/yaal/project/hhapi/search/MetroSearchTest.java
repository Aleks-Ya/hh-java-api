package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.vacancy.Address;
import ru.yaal.project.hhapi.vacancy.Metro;
import ru.yaal.project.hhapi.vacancy.VacanciesList;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertTrue;
import static ru.yaal.project.hhapi.search.VacanciesSearchTest.WITHOUT_PARAMS_VACANCIES_COUNT;

public class MetroSearchTest {
    private ISearch<VacanciesList> search = new VacanciesSearch();

    @Test
    public void testMetroCity() throws SearchException, DictionaryException {
        Dictionaries.setLoader(new FakeContentLoader());
        MetroCity metroExpected = Dictionaries.getMetro().getEntryByName("САНКТ-Петербург");
        search.addParameter(metroExpected);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(9000 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                Metro metroActual = address.getMetro();
                if (!metroActual.isNull()) {
                    assertTrue(metroActual.getMetroId().startsWith(metroExpected.getId()));
                } else {
                    System.out.println(address);
                }

            }
        }
    }
}
