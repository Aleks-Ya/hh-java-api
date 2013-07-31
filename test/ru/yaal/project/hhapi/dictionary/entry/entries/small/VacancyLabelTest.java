package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.*;

public class VacancyLabelTest {

    @Test
    public void searchByOneLabel() throws SearchException, LoadException, ParseException {
        final int limit = 10;
        ISearch<IterableVacancyList> search = new IterableVacancySearch(limit);
        search.addParameter(VacancyLabel.ACCEPT_HANDICAPPED);
        IterableVacancyList vacancies = search.search();
        assertEquals(limit, vacancies.size());
        for (Vacancy vacancy : vacancies) {
            assertTrue(vacancy.getAcceptHandicapped());
        }
    }

    @Test
    public void searchByMultiLabels() throws SearchException, LoadException, ParseException {
        final int limit = 100;
        ISearch<IterableVacancyList> search = new IterableVacancySearch(limit);
        search.addParameter(VacancyLabel.ACCEPT_HANDICAPPED);
        search.addParameter(VacancyLabel.WITH_ADDRESS);
        IterableVacancyList vacancies = search.search();
        assertEquals(limit, vacancies.size());
        for (Vacancy vacancy : vacancies) {
            assertTrue(vacancy.getAcceptHandicapped());
            assertFalse(vacancy.getAddress().isNull());
        }
    }
}
