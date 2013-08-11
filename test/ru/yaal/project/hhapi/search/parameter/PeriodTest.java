package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.VacancyList;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PeriodTest {

    @Test(expected = SearchException.class)
    public void testSetPeriodIncorrect1() throws Exception {
        new Period(0);
    }

    @Test(expected = SearchException.class)
    public void testSetPeriodIncorrect2() throws Exception {
        new Period(31);
    }

    /**
     * Ќельз€ провер€ть правильность периода по дате создани€ вакансии, т.к.
     * вакансии возвращаютс€ из кэша и их дата создани€ отличаетс€ от текущей.
     */
    @Test
    public void testPeriod() throws SearchException {
        VacancyList vacancies = HhApi.search(new Period(1));
        assertThat(vacancies, hasSize(greaterThan(0)));
    }
}
