package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ProfFieldTest {

    @Test
    public void searchByProfField() throws Exception {
        final ProfField expProfField = ProfField.PROF_FIELDS.getById("18.291");
        for (Vacancy vacancy : TestHelper.search(expProfField)) {
            assertThat(vacancy.getProfFields(), everyItem(equalTo(expProfField)));
        }
    }

    @Test
    public void searchByMultiProfFields1() throws Exception {
        final ProfField expField1 = ProfField.PROF_FIELDS.getById("18.298");
        final ProfField expField2 = ProfField.PROF_FIELDS.getById("22.11");
        for (Vacancy vacancy : TestHelper.search(expField1, expField2)) {
            assertThat(vacancy.getProfFields(), everyItem(isOneOf(expField1, expField2)));
        }
    }

    @Test
    public void searchByMultiProfFields2() throws DictionaryException, SearchException, LoadException, ParseException {
        final ProfField programming = ProfField.PROF_FIELDS.getById("1.221");
        final ProfField copywriter = ProfField.PROF_FIELDS.getById("3.119");
        for (Vacancy vacancy : TestHelper.search(programming, copywriter)) {
            assertThat(vacancy.getProfFields(), everyItem(isOneOf(programming, copywriter)));
        }
    }
}