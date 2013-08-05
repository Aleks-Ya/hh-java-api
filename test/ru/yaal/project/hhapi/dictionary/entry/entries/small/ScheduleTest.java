package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ScheduleTest {
    @Test
    public void searchMultiParameters() throws Exception {
        final Schedule expSchedule1 = Schedule.REMOTE;
        final Schedule expSchedule2 = Schedule.SHIFT;
        for (Vacancy vacancy : TestHelper.search(expSchedule1, expSchedule2)) {
            Schedule actSchedule = vacancy.getSchedule();
            assertTrue(actSchedule.equals(expSchedule1) || actSchedule.equals(expSchedule2));
            assertThat(actSchedule, isOneOf(expSchedule1, expSchedule2));
        }
    }
}
