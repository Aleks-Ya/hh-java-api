package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.OnlyWithSalary;
import ru.yaal.project.hhapi.search.parameter.Text;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class VacanciesSearchTest {
    private static final int WITHOUT_PARAMS_VACANCIES_COUNT = 290000;
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

    @Test
    public void testOnlyWithSalary() throws SearchException {
        ISearchParameter onlyWithSalary = new OnlyWithSalary();
        search.addParameter(onlyWithSalary);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(100000 < result.getFound());
    }

    @Test
    public void testSchedule() throws SearchException, DictionaryException {
        ISearchParameter schedule = Dictionaries.getSchedule().getEntryById("shift");
        search.addParameter(schedule);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(30000 < result.getFound());
    }
}
