package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.junit.Assert.assertThat;
import static uk.co.it.modular.hamcrest.date.DateMatchers.after;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDay;

public class OrderTest {
    @Test
    public void testVacancySearchOrder() throws SearchException, DictionaryException {
        final int count = 20;
        IterableVacancyList vacancies = new IterableVacancySearch(count)
                .addParameter(Order.PUBLICATION_TIME)
                .search();
        assertEquals(count, vacancies.size());
        List<Vacancy> vacancyList = vacancies.toList();
        for (int v = 0; (v + 1) < 20; v++) {
            Date create1 = vacancyList.get(v).getCreatedAt();
            Date created20 = vacancyList.get(v + 1).getCreatedAt();
            assertThat(create1, anyOf(sameDay(created20), after(created20)));
        }
    }
}
