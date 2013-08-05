package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.OnlyWithSalary;
import ru.yaal.project.hhapi.search.SearchParamNames;

import static org.junit.Assert.*;

public class SalaryTest {
    //todo переписать использу€ Salary.toRur() и assertSalary()
    public static void assertSalary(Salary expectedSalary, Salary actualSalary) throws SearchException {
        Salary expectedSalaryRur = Salary.toRur(expectedSalary);
        Salary actualSalaryRur = Salary.toRur(actualSalary);
        Integer expectedValue = Integer.valueOf(expectedSalaryRur.getSearchParameters().getParameterMap().get(SearchParamNames.SALARY).get(0));
        assertNotNull(expectedValue);
        Integer actualTo = actualSalaryRur.getTo();
        Integer actualFrom = actualSalaryRur.getFrom();
        assertTrue(actualTo != null || actualFrom != null);
        actualTo = (actualTo != null) ? actualTo : actualFrom;
        actualFrom = (actualFrom != null) ? actualFrom : actualTo;
        assertTrue(expectedValue >= actualFrom || expectedValue <= actualTo);
    }

    @Test(expected = SearchException.class)
    public void testSalaryNotSpecified() throws SearchException, DictionaryException {
        ISearchParameter parameter = new Salary(null, null);
        parameter.getSearchParameters();
    }

    @Test
    public void putCurrencyToSearchParams() throws SearchException {
        final Currency expectedCurrency = Currency.USD;
        final int salaryUsd = 1000;
        final Salary expectedSalary = new Salary(salaryUsd, salaryUsd, expectedCurrency);
        ISearch<IterableVacancyList> search = new IterableVacancySearch(100)
                .addParameter(expectedSalary)
                .addParameter(OnlyWithSalary.ON);
        IterableVacancyList vacancies = search.search();
        for (Vacancy vacancy : vacancies) {
            Salary actualSalary = vacancy.getSalary();
            System.out.println(actualSalary.getFrom());
            System.out.println(actualSalary.getTo());
            System.out.println(actualSalary.getCurrency());
            assertSalary(expectedSalary, actualSalary);
        }
    }

    @Test
    public void toRur() {
        int fromUsd = 1000;
        int toUsd = 3000;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertTrue(salaryRur.getFrom() > fromUsd * 29);
        assertTrue(salaryRur.getTo() < toUsd * 35);
        assertEquals(Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurNullFrom() {
        Integer fromUsd = null;
        int toUsd = 3000;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertNull(salaryRur.getFrom());
        assertTrue(salaryRur.getTo() < toUsd * 35);
        assertEquals(Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurNullTo() {
        int fromUsd = 1000;
        Integer toUsd = null;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertTrue(salaryRur.getFrom() > fromUsd * 29);
        assertNull(salaryRur.getTo());
        assertEquals(Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurNulls() {
        Integer fromUsd = null;
        Integer toUsd = null;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertNull(salaryRur.getFrom());
        assertNull(salaryRur.getTo());
        assertEquals(Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurFromRur() {
        Integer from = 1000;
        Integer to = 3000;
        Salary salary = new Salary(from, to, Currency.RUR);
        Salary salaryRur = Salary.toRur(salary);
        assertEquals(from, salaryRur.getFrom());
        assertEquals(to, salaryRur.getTo());
        assertEquals(Currency.RUR, salaryRur.getCurrency());
    }

}
