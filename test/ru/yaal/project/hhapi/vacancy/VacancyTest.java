package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.search.ISearch;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class VacancyTest {
    @Test
    public void vacancyToString() throws Exception {
        ISearch<PageableVacancyList> search = new PageableVacancySearch();
        PageableVacancyList vacancyList = search.search();
        Vacancy vacancy = vacancyList.getVacanciesOnPage(1).toList().get(0);
        final String vacancyExpected = format("%s(%s)", vacancy.getName(), vacancy.getId());
        assertEquals(vacancyExpected, vacancy.toString());
    }
}
