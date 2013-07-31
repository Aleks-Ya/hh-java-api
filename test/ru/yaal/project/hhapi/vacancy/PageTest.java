package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.search.SearchException;

public class PageTest {

    @Test
    public void testCorrectPage() throws SearchException {
        new Page(1);
    }

    @Test(expected = SearchException.class)
    public void testIncorrectPage() throws SearchException {
        new Page(0);
    }
}
