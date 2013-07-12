package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.search.SearchException;

public class PerPageTest {
    @Test
    public void testCorrectPerPage1() throws SearchException {
        new PerPage(1);
        new PerPage(500);
    }

    @Test(expected = SearchException.class)
    public void testIncorrectPerPage1() throws SearchException {
        new PerPage(0);
    }

    @Test(expected = SearchException.class)
    public void testIncorrectPerPage2() throws SearchException {
        new PerPage(501);
    }
}