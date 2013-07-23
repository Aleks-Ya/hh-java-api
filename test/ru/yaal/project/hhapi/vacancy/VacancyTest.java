package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.VacanciesSearch;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class VacancyTest {
    @Test
    public void vacancyToString() throws Exception {
        ISearch<VacancyList> search = new VacanciesSearch();
        VacancyList vacancyList = search.search();
        final String listExpected = format("VacancyList(found=%d, pages=100, perPage=20, page=0)", vacancyList.getFound());
        assertEquals(listExpected, vacancyList.toString());
        Vacancy vacancy = vacancyList.getItems().get(0);
        final String vacancyExpected = format("%s(%s)", vacancy.getName(), vacancy.getId());
        assertEquals(vacancyExpected, vacancy.toString());
    }
}
