package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.Text;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class VacanciesSearchTest {
    @Test
    public void test() throws SearchException {
        ISearch<VacanciesList> search = new VacanciesSearch();
        ISearchParameter textParam = new Text("java");
        search.addParameter(textParam);
        VacanciesList result = search.search();
        assertNotNull(result);
        assertTrue(290000 > result.getFound());
        assertTrue(1000 < result.getFound());
    }
}
