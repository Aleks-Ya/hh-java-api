package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PageableVacancySearchTest {
    private final ISearch<PageableVacancyList> search = new PageableVacancySearch();

    @Test
    public void testSearch() throws Exception {
        search.addParameter(new Text("scala"));
        PageableVacancyList pageableVacancyList = search.search();
        List<Vacancy> actualList = new ArrayList<>(pageableVacancyList.getVacanciesAmount());
        for (IterableVacancyList vacancyList : pageableVacancyList) {
            actualList.addAll(vacancyList.toList());
        }
        assertEquals(pageableVacancyList.getVacanciesAmount(), actualList.size());
    }

    @Test
    public void toList() throws SearchException {
        search.addParameter(new Text("scala"));
        PageableVacancyList pageableVacancyList = search.search();
        assertEquals(pageableVacancyList.getVacanciesAmount(), pageableVacancyList.toList().size());
    }

    @Test
    public void getVacanciesOnPage() throws SearchException {
        search.addParameter(new Text("scala"));
        final int perPage = 20;
        search.addParameter(new PerPage(perPage));
        PageableVacancyList pvl = search.search();
        int pages = pvl.getPageAmount();
        for (int i = 1; i <= pages - 1; i++) {
            assertEquals(perPage, pvl.getVacanciesOnPage(i).size());
        }
        //количество вакансий на последней странице не равно perPage
        int remainder = pvl.getVacanciesAmount() - (pages - 1) * pvl.getVacanciesPerPage();
        assertEquals(remainder, pvl.getVacanciesOnPage(pages).size());
    }
}
