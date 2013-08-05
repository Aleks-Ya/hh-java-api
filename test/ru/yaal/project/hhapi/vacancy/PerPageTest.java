package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testPerPage() throws SearchException, DictionaryException {
        final Integer perPageCount = 5;
        PerPage perPage = new PerPage(perPageCount);
        ISearch<VacancyPage> search = new VacancySearch();
        search.addParameter(perPage);
        VacancyPage result = search.search();
        assertEquals(perPageCount, result.getPerPage());
        assertEquals((Object) perPageCount, result.getItems().size());
    }
}