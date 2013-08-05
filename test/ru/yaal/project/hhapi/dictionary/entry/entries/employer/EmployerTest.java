package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import org.junit.Test;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EmployerTest {
    @Test
    public void testGetSearchParameters() throws Exception {
        final Employer expectedEmployer1 = new Employer("1455");
        final Employer expectedEmployer2 = new Employer("6591");
        IterableVacancyList vacancies = new IterableVacancySearch(50)
                .addParameter(expectedEmployer1)
                .addParameter(expectedEmployer2)
                .search();
        assertTrue(vacancies.size() > 0);
        for (Vacancy vacancy : vacancies) {
            Employer actualEmployer = vacancy.getEmployer();
            assertThat(actualEmployer, isOneOf(expectedEmployer1, expectedEmployer2));
        }
    }
}
