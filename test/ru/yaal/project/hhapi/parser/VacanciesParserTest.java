package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.VacanciesParser;
import ru.yaal.project.hhapi.vacancy.Vacancy;
import ru.yaal.project.hhapi.vacancy.VacancyList;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class VacanciesParserTest {
    @Test
    public void test() throws Exception {
        String content = ContentLoaderFactory.newInstanceLongTermCache().loadContent(UrlConstants.VACANCIES_URL);
        IParser<VacancyList> parser = new VacanciesParser();
        VacancyList vacancies = parser.parse(content);
        assertNotNull(vacancies);
        assertTrue(290000 < vacancies.getFound());
        assertTrue(20 == vacancies.getItems().size());
        int notNullSalaryCount = 0;
        for (Vacancy vacancy : vacancies.getItems()) {
            Salary salary = vacancy.getSalary();
            assertNotNull(salary);
            if (!salary.isNull()) notNullSalaryCount++;
        }
        assertThat(notNullSalaryCount, greaterThan(1));
    }

}
