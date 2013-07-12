package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.search.SearchException;

public class PeriodTest {
    @Test(expected = SearchException.class)
    public void testSetPeriodIncorrect1() throws Exception {
        new Period(0);
    }

    @Test(expected = SearchException.class)
    public void testSetPeriodIncorrect2() throws Exception {
        new Period(31);
    }
}
