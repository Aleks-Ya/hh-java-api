package ru.yaal.project.hhapi.search;

import org.junit.Test;

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
