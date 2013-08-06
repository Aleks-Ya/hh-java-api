package ru.yaal.project.hhapi;

import org.junit.Test;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.Vacancy;
import ru.yaal.project.hhapi.vacancy.VacancyList;

/**
 * »щем вакансии с текстом "Hello World"
 */
public class HelloWorldTest {
    @Test
    public void helloWorld() throws SearchException {
        VacancyList vacancies = HhApi.search(new Text("Hello World"));
        for (Vacancy vacancy : vacancies) {
            System.out.printf("%s (%s)\n", vacancy.getName(), vacancy.getArea());
        }
    }
}
