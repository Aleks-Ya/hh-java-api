package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.Text;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class TextSearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void testText() throws SearchException {
        ISearchParameter textParam = new Text("java");
        search.addParameter(textParam);
        VacancyList result = search.search();
        assertNotNull(result);
        assertTrue(VacancySearchTest.WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertThat(result.getFound(), greaterThan(1000));
    }

    @Test
    public void searchMultiParams() throws SearchException, LoadException, ParseException {
        final String searchText = "java";
        ISearchParameter text = new Text(searchText, VacancySearchFields.DESCRIPTION, VacancySearchFields.VACANCY_NAME);
        IterableVacancyList vacancies = new IterableVacancySearch(50)
                .addParameter(text)
                .search();
        final String searchTextUpperCase = searchText.toUpperCase();
        for (Vacancy vacancy : vacancies) {
            String name = vacancy.getName().toUpperCase();
            String description = vacancy.getDescription().toUpperCase();
            assertTrue(name.contains(searchTextUpperCase) || description.contains(searchTextUpperCase));
        }
    }

}
