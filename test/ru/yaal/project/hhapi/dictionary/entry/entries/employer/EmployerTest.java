package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

public class EmployerTest {
    @Test
    public void testGetSearchParameters() throws Exception {
        final Employer expEmployer1 = new Employer("1455");
        final Employer expEmployer2 = new Employer("6591");
        for (Vacancy vacancy : TestHelper.search(expEmployer1, expEmployer2)) {
            Employer actEmployer = vacancy.getEmployer();
            assertThat(actEmployer, isOneOf(expEmployer1, expEmployer2));
        }
    }
}
