package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.anyOf;
import static org.junit.Assert.assertThat;
import static uk.co.it.modular.hamcrest.date.DateMatchers.*;

public class PeriodTest {
    @Test(expected = SearchException.class)
    public void testSetPeriodIncorrect1() throws Exception {
        new Period(0);
    }

    @Test(expected = SearchException.class)
    public void testSetPeriodIncorrect2() throws Exception {
        new Period(31);
    }

    @Test
    public void testPeriod() throws SearchException {
        for (Vacancy vacancy : HhApi.search(new Period(1))) {
            assertThat(vacancy.getCreatedAt(), anyOf(isYesterday(), isToday(), isTomorrow()));
        }
    }
}
