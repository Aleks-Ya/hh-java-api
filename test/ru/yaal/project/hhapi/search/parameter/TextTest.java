package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertTrue;

public class TextTest {

    @Test
    public void searchByText() throws SearchException, LoadException, ParseException {
        final String searchText = "java";
        final String searchTextUpperCase = searchText.toUpperCase();
        for (Vacancy vacancy : HhApi.search(new Text(searchText))) {
            String name = vacancy.getName().toUpperCase();
            String description = vacancy.getDescription().toUpperCase();
            assertTrue(name.contains(searchTextUpperCase) || description.contains(searchTextUpperCase));
        }
    }

    @Test
    public void searchByMultiParams() throws SearchException, LoadException, ParseException {
        final String searchText = "java";
        final String searchTextUpperCase = searchText.toUpperCase();
        for (Vacancy vacancy : HhApi.search(new Text(searchText))) {
            String name = vacancy.getName().toUpperCase();
            String description = vacancy.getDescription().toUpperCase();
            assertTrue(name.contains(searchTextUpperCase) || description.contains(searchTextUpperCase));
        }
    }

}
