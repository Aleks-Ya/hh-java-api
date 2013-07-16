package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.Text;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static ru.yaal.project.hhapi.search.VacanciesSearchTest.WITHOUT_PARAMS_VACANCIES_COUNT;

public class TextSearchTest {
    private ISearch<VacanciesList> search = new VacanciesSearch();

    @Test
    public void testText() throws SearchException {
        ISearchParameter textParam = new Text("java");
        search.addParameter(textParam);
        VacanciesList result = search.search();
        assertNotNull(result);
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(1000 < result.getFound());
    }

}
