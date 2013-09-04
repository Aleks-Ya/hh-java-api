package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ScheduleTest {
    @Test
    public void searchBySchedule() throws Exception {
        final Schedule expSchedule = Constants.Schedule.SHIFT;
        for (Vacancy vacancy : HhApi.search(expSchedule)) {
            assertEquals(vacancy.getSchedule(), expSchedule);
        }
    }

    @Test
    public void searchByMultiSchedules() throws Exception {
        final Schedule expSchedule1 = Constants.Schedule.REMOTE;
        final Schedule expSchedule2 = Constants.Schedule.SHIFT;
        for (Vacancy vacancy : HhApi.search(expSchedule1, expSchedule2)) {
            Schedule actSchedule = vacancy.getSchedule();
            assertThat(actSchedule, isOneOf(expSchedule1, expSchedule2));
        }
    }
}
