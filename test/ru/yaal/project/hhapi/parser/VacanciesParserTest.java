package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.VacanciesList;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.*;

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
        int notNullSalaryCount = 0;
        for (Vacancy vacancy : vacancies.getItems()) {
            Salary salary = vacancy.getSalary();
            assertNotNull(salary);
            if (!salary.isNull()) notNullSalaryCount++;
        }
        assertTrue(10 < notNullSalaryCount);
    }

}
