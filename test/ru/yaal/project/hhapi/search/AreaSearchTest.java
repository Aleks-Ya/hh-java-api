package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.yaal.project.hhapi.search.VacanciesSearchTest.WITHOUT_PARAMS_VACANCIES_COUNT;

public class AreaSearchTest {
    private ISearch<VacanciesList> search = new VacanciesSearch();

    @Test
    public void testArea() throws SearchException, DictionaryException {
        Dictionaries.setLoader(new FakeContentLoader());
        final Area expectedArea = Dictionaries.getArea().getEntryByName("Ñàíêò-ÏÅÒÅÐÁÓÐÃ");
        search.addParameter(expectedArea);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(20000 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Area actualArea = vacancy.getArea();
            assertEquals(expectedArea, actualArea);
        }
    }
}
