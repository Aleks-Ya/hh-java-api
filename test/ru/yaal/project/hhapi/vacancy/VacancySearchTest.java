package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Order;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.Period;

import java.util.Date;
import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;
import static uk.co.it.modular.hamcrest.date.DateMatchers.after;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDay;

public class VacancySearchTest {
    public static final int WITHOUT_PARAMS_VACANCIES_COUNT = 290000;
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void testSchedule() throws SearchException, DictionaryException {
        search.addParameter(Schedule.SHIFT);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(30000 < result.getFound());
        assertThat(result.getFound(), greaterThan(30000));
    }

    @Test
    public void testVacancySearchOrder() throws SearchException, DictionaryException {
        search.addParameter(Order.PUBLICATION_TIME);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT < result.getFound());
        List<Vacancy> vacancies = result.getItems();
        for (int v = 0; (v + 1) < 20; v++) {
            Date create1 = vacancies.get(v).getCreatedAt();
            Date created20 = vacancies.get(v + 1).getCreatedAt();
            assertThat(create1, anyOf(sameDay(created20), after(created20)));
            assertThat(result.getFound(), greaterThan(50000));
        }
    }

    @Test
    public void testPerPage() throws SearchException, DictionaryException {
        final Integer perPageCount = 5;
        PerPage perPage = new PerPage(perPageCount);
        search.addParameter(perPage);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT < result.getFound());
        assertEquals(perPageCount, result.getPerPage());
        assertEquals((Object) perPageCount, result.getItems().size());
    }

    @Test
    public void testPeriod() throws SearchException, DictionaryException {
        Period period = new Period(1);
        search.addParameter(period);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertThat(result.getFound(), greaterThan(4000));
    }

    @Test
    public void testExperience() throws Exception {
        search.addParameter(Experience.MORE_THAN_6);
        VacancyList result = search.search();
        assertTrue(WITHOUT_PARAMS_VACANCIES_COUNT > result.getFound());
        assertTrue(6000 < result.getFound());
        IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
        IParser<Vacancy> parser = new VacancyParser();
        for (Vacancy vacancy : result.getItems()) {
            String content = loader.loadContent(format(UrlConstants.VACANCY_URL, vacancy.getId()));
            Vacancy detailedVacancy = parser.parse(content);
            assertEquals(detailedVacancy.getExperience(), Experience.MORE_THAN_6);
        }
    }
}
