package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchOrder;
import ru.yaal.project.hhapi.search.parameter.*;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class VacanciesSearchTest {
    private static final int WITHOUT_PARAMS_VACANCIES_COUNT = 299000;
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

    @Test
    public void testSalary() throws SearchException, DictionaryException {
        Salary salary = new Salary(100000, 150000);
        search.addParameter(salary);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(50000 < result.getFound());
    }

    @Test
    public void testSalaryAndOnlyWithSalary() throws SearchException, DictionaryException {
        ISearchParameter onlyWithSalary = new OnlyWithSalary();
        Salary salary = new Salary(100000, 150000);
        search.addParameter(salary).addParameter(onlyWithSalary);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(15000 < result.getFound());
    }

    @Test
    public void testCoordinates() throws SearchException, DictionaryException {
        Coordinates coordinates = new Coordinates(59.932243, 59.915611, 30.303541, 30.360532);
        search.addParameter(coordinates);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(300 < result.getFound());
    }

    @Test
    public void testVacancySearchOrder() throws SearchException, DictionaryException {
        VacancySearchOrder order = Dictionaries.getVacancySearchOrder().getEntryById("publication_time");
        search.addParameter(order);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT < result.getFound());
        List<Vacancy> vacancies = result.getItems();
        for (int v = 0; (v + 1) < 20; v++) {
            Date create1 = vacancies.get(v).getCreatedAt();
            Date created20 = vacancies.get(v + 1).getCreatedAt();
            assertTrue(create1.after(created20));
        }
    }

    @Test
    public void testPerPage() throws SearchException, DictionaryException {
        final Integer perPageCount = 1;
        PerPage perPage = new PerPage(perPageCount);
        search.addParameter(perPage);
        VacanciesList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT < result.getFound());
        assertEquals(perPageCount, result.getPerPage());
        assertEquals((Object) perPageCount, result.getItems().size());
    }
}
