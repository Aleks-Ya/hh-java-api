package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
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
    public void testPage() throws SearchException {
        VacancyPage vacancyPage1 = new VacancyPageSearch().addParameter(new Page(1)).search();
        int pages = vacancyPage1.getPages();
        int perPage = vacancyPage1.getPerPage();
        int itemsCount = vacancyPage1.getItems().size();

        for (int page = 1; page <= 5; page++) {
            VacancyPage vacancyPage = new VacancyPageSearch().addParameter(new Page(page)).search();
            assertThat(vacancyPage.getPage(), is(page));
            assertThat(vacancyPage.getPages(), is(pages));
            assertThat(vacancyPage.getPerPage(), is(perPage));
            assertThat(vacancyPage.getItems(), hasSize(itemsCount));
        }
    }
}
