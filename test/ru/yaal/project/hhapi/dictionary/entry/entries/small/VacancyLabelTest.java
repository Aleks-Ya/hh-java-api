package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VacancyLabelTest {

    @Test
    public void searchByOneLabel() throws SearchException, LoadException, ParseException {
        for (Vacancy vacancy : TestHelper.search(10, VacancyLabel.ACCEPT_HANDICAPPED)) {
            assertTrue(vacancy.getAcceptHandicapped());
        }
    }

    @Test
    public void searchByMultiLabels() throws SearchException, LoadException, ParseException {
        for (Vacancy vacancy : TestHelper.search(100, VacancyLabel.ACCEPT_HANDICAPPED, VacancyLabel.WITH_ADDRESS)) {
            assertTrue(vacancy.getAcceptHandicapped());
            assertFalse(vacancy.getAddress().isNull());
        }
    }
}
