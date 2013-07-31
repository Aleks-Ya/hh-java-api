package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.Text;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TextSearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void testText() throws SearchException {
        ISearchParameter textParam = new Text("java");
        search.addParameter(textParam);
        VacancyList result = search.search();
        assertNotNull(result);
        assertTrue(VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(1000 < result.getFound());
    }

}
