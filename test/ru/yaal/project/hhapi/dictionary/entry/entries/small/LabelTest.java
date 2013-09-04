package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.yaal.project.hhapi.dictionary.Constants.Label.ACCEPT_HANDICAPPED;
import static ru.yaal.project.hhapi.dictionary.Constants.Label.WITH_ADDRESS;

public class LabelTest {

    @Test
    public void searchByOneLabel() throws SearchException, IOException {
        for (Vacancy vacancy : HhApi.search(10, ACCEPT_HANDICAPPED)) {
            assertTrue(vacancy.getAcceptHandicapped());
        }
    }

    @Test
    public void searchByMultiLabels() throws SearchException, IOException {
        for (Vacancy vacancy : HhApi.search(100, ACCEPT_HANDICAPPED, WITH_ADDRESS)) {
            assertTrue(vacancy.getAcceptHandicapped());
            assertFalse(vacancy.getAddress().isNull());
        }
    }
}
