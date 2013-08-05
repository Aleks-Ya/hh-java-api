package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;
import static ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment.*;

@RunWith(value = Parameterized.class)
public class EmploymentTest {
    private List<ISearchParameter> parameters;

    public EmploymentTest(List<ISearchParameter> parameters) {
        this.parameters = parameters;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Iterable<Object[]> getTestParameters() {
        return Arrays.asList(
                new Object[]{asList(FULL)},
                new Object[]{asList(PART)},
                new Object[]{asList(PROJECT)},
                new Object[]{asList(PROBATION)},
                new Object[]{asList(VOLUNTEER)},
                new Object[]{asList(PART, VOLUNTEER)}
        );
    }

    @Test
    public void searchPart() throws Exception {
        for (Vacancy vacancy : TestHelper.search(parameters)) {
            Employment actualEmployment = vacancy.getEmployment();
            assertThat(actualEmployment, isIn(parameters));
        }
    }

}
