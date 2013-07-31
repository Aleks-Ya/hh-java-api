package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.SmallDictionariesInitializer;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.OnlyWithSalary;

import static org.junit.Assert.assertTrue;

public class SalarySearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void testOnlyWithSalary() throws SearchException {
        ISearchParameter onlyWithSalary = OnlyWithSalary.ON;
        search.addParameter(onlyWithSalary);
        VacancyList result = search.search();
        assertTrue(VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(100000 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Salary salary = vacancy.getSalary();
            assertTrue(salary.getTo() != null || salary.getFrom() != null);
        }
    }

    @Test
    public void testSalary() throws SearchException, DictionaryException {
        final int MIN_SALARY = 100000;
        final int MAX_SALARY = 150000;
        Salary salaryExpected = new Salary(MIN_SALARY, MAX_SALARY);
        search.addParameter(salaryExpected);
        VacancyList result = search.search();
        assertTrue(VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(50000 < result.getFound());
    }

    @Test
    public void testSalaryAndOnlyWithSalary() throws SearchException, DictionaryException {
        final int MIN_SALARY = 100000;
        final int MAX_SALARY = 150000;
        ISearchParameter onlyWithSalary = OnlyWithSalary.ON;
        Salary salaryExpected = new Salary(MIN_SALARY, MAX_SALARY);
        search.addParameter(salaryExpected).addParameter(onlyWithSalary);
        VacancyList result = search.search();
        assertTrue(VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(4000 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Salary salary = vacancy.getSalary();
            Integer to = salary.getTo();
            if (salary.getCurrency() == SmallDictionariesInitializer.getInstance().getCurrency().getById("RUR")) {
                if (to != null) if (!((MIN_SALARY - 10000) <= to))
                    System.out.println("to=" + to);
            }
        }
    }
}
