package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ScheduleTest {
    @Test
    public void searchMultiParameters() throws Exception {
        final Schedule expectedSchedule1 = Schedule.REMOTE;
        final Schedule expectedSchedule2 = Schedule.SHIFT;
        IterableVacancyList vacancies = new IterableVacancySearch(50)
                .addParameter(expectedSchedule1)
                .addParameter(expectedSchedule2)
                .search();
        for (Vacancy vacancy : vacancies) {
            Schedule actualSchedule = vacancy.getSchedule();
            assertTrue(actualSchedule.equals(expectedSchedule1) || actualSchedule.equals(expectedSchedule2));
            assertThat(actualSchedule, isOneOf(expectedSchedule1, expectedSchedule2));
        }
    }
}
