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
        final Schedule expectedSchedule1 = Schedule.REMOTE;
        final Schedule expectedSchedule2 = Schedule.SHIFT;
        for (Vacancy vacancy : TestHelper.search(expectedSchedule1, expectedSchedule2)) {
            Schedule actualSchedule = vacancy.getSchedule();
            assertTrue(actualSchedule.equals(expectedSchedule1) || actualSchedule.equals(expectedSchedule2));
            assertThat(actualSchedule, isOneOf(expectedSchedule1, expectedSchedule2));
        }
    }
}
