package ru.yaal.project.hhapi;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.OnlyWithSalary;
import ru.yaal.project.hhapi.search.parameter.Period;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.Vacancy;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.VacancySearch;

import java.util.List;

/**
 * Найдем вакансии программистов java в Питере (подробный вариант).
 */
public class JavaDeveloperDetailedTest {
    @Test
    public void javaDeveloper() throws SearchException {
        ISearchParameter text = new Text("java", Constants.VacancySearchFields.VACANCY_NAME);
        ISearchParameter area = Area.AREAS.getByName("Санкт-Петербург");
        ISearchParameter profField = ProfField.PROF_FIELDS.getById("1.221");//Программирование
        ISearchParameter salary = new Salary(3000, 5000, Constants.Currency.USD);
        ISearchParameter experience = Constants.Experience.BETWEEN_3_AND_6;
        ISearchParameter onlyWithSalary = OnlyWithSalary.ON;
        ISearchParameter order = Constants.Order.SALARY_DESC;
        ISearchParameter period = new Period(30);
        ISearchParameter schedule = Constants.Schedule.FULL_DAY;
        ISearchParameter employment = Constants.Employment.FULL;

        ISearch<VacancyList> search = new VacancySearch(50)
                .addParameter(text)
                .addParameter(area)
                .addParameter(profField)
                .addParameter(salary)
                .addParameter(experience)
                .addParameter(onlyWithSalary)
                .addParameter(period)
                .addParameter(schedule)
                .addParameter(employment)
                .addParameter(order);

        List<Vacancy> vacancies = search.search();

        System.out.printf("Нашлось %d вакансий.\n", vacancies.size());
    }
}
