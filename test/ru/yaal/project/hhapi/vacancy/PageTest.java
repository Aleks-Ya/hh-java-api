package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.SearchException;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PageTest {

    @Test
    public void testCorrectPage() throws SearchException {
        new Page(1);
    }

    @Test(expected = SearchException.class)
    public void testIncorrectPage() throws SearchException {
        new Page(0);
    }

    @Test
    public void testPage() throws SearchException, DictionaryException {
        VacancyList vacancyList1 = new VacancySearch().addParameter(new Page(1)).search();
        int pages = vacancyList1.getPages();
        int perPage = vacancyList1.getPerPage();
        int itemsCount = vacancyList1.getItems().size();

        for (int page = 1; page <= 5; page++) {
            VacancyList vacancyList = new VacancySearch().addParameter(new Page(page)).search();
            assertThat(vacancyList.getPage(), is(page));
            assertThat(vacancyList.getPages(), is(pages));
            assertThat(vacancyList.getPerPage(), is(perPage));
            assertThat(vacancyList.getItems(), hasSize(itemsCount));
        }
    }
}
