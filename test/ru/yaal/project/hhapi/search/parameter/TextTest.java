package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextTest {

    @Test
    public void searchByText() throws SearchException, LoadException, ParseException {
        final int count = 20;
        final String searchText = "java";
        IterableVacancyList vacancies = new IterableVacancySearch(count)
                .addParameter(new Text(searchText)).search();
        assertEquals(count, vacancies.size());
        final String searchTextUpperCase = searchText.toUpperCase();
        for (Vacancy vacancy : vacancies) {
            String name = vacancy.getName().toUpperCase();
            String description = vacancy.getDescription().toUpperCase();
            assertTrue(name.contains(searchTextUpperCase) || description.contains(searchTextUpperCase));
        }
    }

    @Test
    public void searchByMultiParams() throws SearchException, LoadException, ParseException {
        final int count = 20;
        final String searchText = "java";
        ISearchParameter text = new Text(searchText, VacancySearchFields.DESCRIPTION, VacancySearchFields.VACANCY_NAME);
        IterableVacancyList vacancies = new IterableVacancySearch(count)
                .addParameter(text)
                .search();
        assertEquals(count, vacancies.size());
        final String searchTextUpperCase = searchText.toUpperCase();
        for (Vacancy vacancy : vacancies) {
            String name = vacancy.getName().toUpperCase();
            String description = vacancy.getDescription().toUpperCase();
            assertTrue(name.contains(searchTextUpperCase) || description.contains(searchTextUpperCase));
        }
    }

}
