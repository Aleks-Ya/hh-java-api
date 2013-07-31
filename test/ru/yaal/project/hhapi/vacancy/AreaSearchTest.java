package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AreaSearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void testArea() throws SearchException, DictionaryException {
        final Area expectedArea = Area.AREAS.getByName("Ñàíêò-ÏÅÒÅÐÁÓÐÃ");
        search.addParameter(expectedArea);
        VacancyList result = search.search();
        assertTrue(VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(20000 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Area actualArea = vacancy.getArea();
            assertEquals(expectedArea, actualArea);
        }
    }
}
