package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ScheduleTest {
    @Test
    public void searchBySchedule() throws Exception {
        final Schedule expSchedule = Schedule.SHIFT;
        for (Vacancy vacancy : TestHelper.search(expSchedule)) {
            assertEquals(vacancy.getSchedule(), expSchedule);
        }
    }

    @Test
    public void searchByMultiSchedules() throws Exception {
        final Schedule expSchedule1 = Schedule.REMOTE;
        final Schedule expSchedule2 = Schedule.SHIFT;
        for (Vacancy vacancy : TestHelper.search(expSchedule1, expSchedule2)) {
            Schedule actSchedule = vacancy.getSchedule();
            assertThat(actSchedule, isOneOf(expSchedule1, expSchedule2));
        }
    }
}
