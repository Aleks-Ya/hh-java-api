package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertEquals;

public class ExperienceTest {

    @Test
    public void searchByExperience() throws Exception {
        final Experience expExperience = Experience.MORE_THAN_6;
        for (Vacancy vacancy : TestHelper.search(expExperience)) {
            assertEquals(vacancy.getExperience(), expExperience);
        }
    }
}
