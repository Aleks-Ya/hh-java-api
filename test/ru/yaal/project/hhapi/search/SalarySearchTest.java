package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.OnlyWithSalary;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertTrue;
import static ru.yaal.project.hhapi.search.VacanciesSearchTest.WITHOUT_PARAMS_VACANCIES_COUNT;

public class SalarySearchTest {
    private ISearch<VacancyList> search = new VacanciesSearch();

    @Test
    public void testOnlyWithSalary() throws SearchException {
        ISearchParameter onlyWithSalary = new OnlyWithSalary();
        search.addParameter(onlyWithSalary);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
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
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(50000 < result.getFound());
    }

    @Test
    public void testSalaryAndOnlyWithSalary() throws SearchException, DictionaryException {
        final int MIN_SALARY = 100000;
        final int MAX_SALARY = 150000;
        ISearchParameter onlyWithSalary = new OnlyWithSalary();
        Salary salaryExpected = new Salary(MIN_SALARY, MAX_SALARY);
        search.addParameter(salaryExpected).addParameter(onlyWithSalary);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(4000 < result.getFound());
        for (Vacancy vacancy : result.getItems()) {
            Salary salary = vacancy.getSalary();
            Integer to = salary.getTo();
            if (salary.getCurrency() == Dictionaries.getCurrency().getEntryById("RUR")) {
                if (to != null) if (!((MIN_SALARY - 10000) <= to))
                    System.out.println("to=" + to);
            }
        }
    }
}
