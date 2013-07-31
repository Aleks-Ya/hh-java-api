package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VacancyLabelTest {

    @Test
    public void searchByLable() throws SearchException, LoadException, ParseException {
        ISearch<IterableVacancyList> search = new IterableVacancySearch(10);
        search.addParameter(VacancyLabel.ACCEPT_HANDICAPPED);
        IterableVacancyList vacancies = search.search();
        assertEquals(10, vacancies.size());
        for (Vacancy vacancy : vacancies) {
            assertTrue(vacancy.getAcceptHandicapped());
        }
    }
}
