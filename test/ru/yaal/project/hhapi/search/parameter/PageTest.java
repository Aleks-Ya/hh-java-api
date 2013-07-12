package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.search.SearchException;

public class PageTest {
    private static final int CORRECT_PAGE = 1;
    private static final int CORRECT_PER_PAGE = 10;
    @Test
    public void testCorrectPerPage1() throws SearchException {
        new Page(1, 1);
        new Page(CORRECT_PAGE, 500);
    }

    @Test(expected = SearchException.class)
    public void testIncorrectPerPage1() throws SearchException {
        new Page(CORRECT_PAGE, 0);
    }

    @Test(expected = SearchException.class)
    public void testIncorrectPerPage2() throws SearchException {
        new Page(CORRECT_PAGE, 501);
    }

    @Test(expected = SearchException.class)
    public void testIncorrectPage1() throws SearchException {
        new Page(0, CORRECT_PER_PAGE);
    }
}
