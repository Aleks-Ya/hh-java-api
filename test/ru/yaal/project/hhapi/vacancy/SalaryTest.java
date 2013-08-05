package ru.yaal.project.hhapi.vacancy;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.OnlyWithSalary;

import static org.junit.Assert.*;

public class SalaryTest {
    private static final Logger LOG = LoggerFactory.getLogger(SalaryTest.class);

    public static void assertSalary(Integer expectedSalary, Salary actualSalary) throws SearchException {
        assertSalary(new Salary(expectedSalary), actualSalary);
    }

    @Test(expected = SearchException.class)
    public void testSalaryNotSpecified() throws SearchException, DictionaryException {
        ISearchParameter parameter = new Salary(null);
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
            assertThat(actualSalary, SalaryEquals.salaryEquals(actualSalary));
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

    public static class SalaryEquals extends TypeSafeMatcher<Salary> {
        private Salary actualSalary;

        public SalaryEquals(Salary actualSalary) {
            this.actualSalary = actualSalary;
        }

        @Factory
        public static org.hamcrest.Matcher<Salary> salaryEquals(Salary actualSalary) {
            return new SalaryEquals(actualSalary);
        }

        @Override
        public boolean matchesSafely(Salary expectedSalary) {
            try {
                Salary expectedSalaryRur = Salary.toRur(expectedSalary);
                Salary actualSalaryRur = Salary.toRur(actualSalary);
                Integer expectedValue = Integer.valueOf(expectedSalaryRur.getSearchParameters()
                        .getParameterMap().get(SearchParamNames.SALARY).get(0));
                assertNotNull(expectedValue);
                Integer actualTo = actualSalaryRur.getTo();
                Integer actualFrom = actualSalaryRur.getFrom();
                assertTrue(actualTo != null || actualFrom != null);
                actualTo = (actualTo != null) ? actualTo : actualFrom;
                actualFrom = (actualFrom != null) ? actualFrom : actualTo;
                return (expectedValue >= actualFrom || expectedValue <= actualTo);
            } catch (SearchException e) {
                LOG.error(e.getMessage(), e);
                return false;
            }
        }

        public void describeTo(Description description) {
            description.appendText("salary not equals:");
            description.appendValue(actualSalary);
        }

    }

}
