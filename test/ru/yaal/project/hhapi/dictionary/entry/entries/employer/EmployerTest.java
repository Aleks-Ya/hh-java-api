package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EmployerTest {

    @Test
    public void searchByEmployer() throws Exception {
        final Employer kafeHouse = new Employer("27986");
        for (Vacancy vacancy : HhApi.search(kafeHouse)) {
            assertEquals(vacancy.getEmployer(), kafeHouse);
        }
    }

    @Test
    public void searchByMultiEmployers() throws Exception {
        final Employer headHunter = new Employer("1455");
        final Employer promSviazBank = new Employer("6591");
        for (Vacancy vacancy : HhApi.search(headHunter, promSviazBank)) {
            assertThat(vacancy.getEmployer(), isOneOf(headHunter, promSviazBank));
        }
    }
}
