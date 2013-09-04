package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.search.parameter.Text;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static ru.yaal.project.hhapi.dictionary.Constants.VacancySearchFields.VACANCY_NAME;

public class VacancySearchTest {
    @Test
    public void searchLimitLess500() throws Exception {
        final String nameText = "java";
        for (Vacancy vacancy : HhApi.search(60, new Text(nameText, VACANCY_NAME))) {
            assertThat(vacancy.getName().toUpperCase(), containsString(nameText.toUpperCase()));
        }
    }

    @Test
    public void searchLimitMore500() throws Exception {
        final String nameText = "java";
        for (Vacancy vacancy : HhApi.search(501, new Text(nameText, VACANCY_NAME))) {
            assertThat(vacancy.getName().toUpperCase(), containsString(nameText.toUpperCase()));
        }
    }
}
