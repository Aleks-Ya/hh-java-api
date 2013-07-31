package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertTrue;

public class EmploymentTest {
    @Test
    public void searchMultiParameters() throws Exception {
        Employment expectedEmployment1 = Employment.PART;
        Employment expectedEmployment2 = Employment.VOLUNTEER;
        IterableVacancyList vacancies = new IterableVacancySearch(50)
                .addParameter(expectedEmployment1)
                .addParameter(expectedEmployment2)
                .search();
        for (Vacancy vacancy : vacancies) {
            Employment actualEmployment = vacancy.getEmployment();
            assertTrue(actualEmployment.equals(expectedEmployment1) || actualEmployment.equals(expectedEmployment2));
        }

    }
}
