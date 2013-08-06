package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.VacancyList;

import java.util.Date;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.junit.Assert.assertThat;
import static uk.co.it.modular.hamcrest.date.DateMatchers.after;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDay;

public class OrderTest {
    @Test
    public void testVacancySearchOrder() throws SearchException {
        VacancyList vacancyList = HhApi.search(Order.PUBLICATION_TIME);
        for (int v = 0; (v + 1) < 20; v++) {
            Date create1 = vacancyList.get(v).getCreatedAt();
            Date created20 = vacancyList.get(v + 1).getCreatedAt();
            assertThat(create1, anyOf(sameDay(created20), after(created20)));
        }
    }
}
