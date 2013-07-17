package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.search.VacanciesList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class VacanciesParserTest {
    @Test
    public void test() throws Exception {
        IContentLoader loader = new FakeContentLoader();
        String content = loader.loadContent(UrlConstants.VACANCIES_URL);
        IParser<VacanciesList> parser = new VacanciesParser();
        VacanciesList vacancies = parser.parse(content);
        assertNotNull(vacancies);
        assertTrue(290000 < vacancies.getFound());
        assertTrue(20 == vacancies.getItems().size());
    }

}
