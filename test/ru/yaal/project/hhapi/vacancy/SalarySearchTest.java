package ru.yaal.project.hhapi.vacancy;

import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.OnlyWithSalary;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SalarySearchTest {
    private ISearch<IterableVacancyList> search;

    @Before
    public void before() throws SearchException {
        search = new IterableVacancySearch();
    }

    @Test
    public void testOnlyWithSalary() throws SearchException {
        search.addParameter(OnlyWithSalary.ON);
        IterableVacancyList vacancies = search.search();
        assertTrue(vacancies.size() > 1);
        for (Vacancy vacancy : vacancies) {
            Salary salary = vacancy.getSalary();
            assertTrue(salary.getTo() != null || salary.getFrom() != null);
        }
    }

    @Test
    public void testSalary() throws SearchException, DictionaryException {
        final int expectedSalary = 100000;
        Salary salaryExpected = new Salary(expectedSalary);
        search.addParameter(salaryExpected);
        IterableVacancyList vacancies = search.search();
        assertTrue(vacancies.size() > 1);
        for (Vacancy vacancy : vacancies) {
            Salary actualSalary = vacancy.getSalary();
            if (actualSalary != null && (actualSalary.getFrom() != null || actualSalary.getTo() != null)) {
                SalaryTest.assertSalary(expectedSalary, actualSalary);
            }
        }
    }

    @Test
    public void testSalaryAndOnlyWithSalary() throws SearchException, DictionaryException {
        final int expectedSalary = 100000;
        Salary salaryExpected = new Salary(expectedSalary);
        search.addParameter(salaryExpected).addParameter(OnlyWithSalary.ON);
        IterableVacancyList vacancies = search.search();
        assertTrue(vacancies.size() > 1);
        for (Vacancy vacancy : vacancies) {
            Salary actualSalary = vacancy.getSalary();
            assertNotNull(actualSalary);
            SalaryTest.assertSalary(expectedSalary, actualSalary);
        }
    }
}
