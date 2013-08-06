package ru.yaal.project.hhapi;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.*;
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

public class HelloWorldTest {

    /**
     * Ищем вакансии с текстом "Hello World"
     */
    @Test
    public void helloWorld() throws SearchException {
        VacancyList vacancies = HhApi.search(new Text("Hello World"));
        for (Vacancy vacancy : vacancies) {
            System.out.printf("%s (%s)\n", vacancy.getName(), vacancy.getArea());
        }
    }

    /**
     * Найдем вакансии программистов java в Питере (компактный вариант).
     */
    @Test
    public void javaDeveloperCompact() throws SearchException {
        VacancyList vacancies = HhApi.search(
                50,
                new Text("java", VacancySearchFields.VACANCY_NAME),
                Area.AREAS.getByName("Санкт-Петербург"),
                ProfField.PROF_FIELDS.getById("1.221"),
                new Salary(3000, 5000, Currency.USD),
                Experience.BETWEEN_3_AND_6,
                OnlyWithSalary.ON,
                Order.SALARY_DESC,
                new Period(30),
                Schedule.FULL_DAY,
                Employment.FULL
        );

        System.out.printf("Нашлось %d вакансий.\n", vacancies.size());
        Vacancy v0 = vacancies.get(0);
        System.out.println(v0.getId());
        System.out.println(v0.getName());
        System.out.println(v0.getSalary());
        System.out.println(v0.getProfFields());
        System.out.println(v0.getExperience());
        System.out.println(v0.getAcceptHandicapped());
        System.out.println(v0.getAddress());
        System.out.println(v0.getArea());
        System.out.println(v0.getSchedule());
        System.out.println(v0.getUrl());
        System.out.println(v0.getArchived());
        System.out.println(v0.getDescription());
        System.out.println(v0.getCreatedAt());
        System.out.println(v0.getEmployer());
        System.out.println(v0.getType());
        System.out.println(v0.getResponseLetterRequired());
        System.out.println(v0.getRelations());
        System.out.println(v0.getEmployment());
        System.out.println(v0.getAlternateUrl());
    }

    /**
     * Найдем вакансии программистов java в Питере (подробный вариант) .
     */
    @Test
    public void javaDeveloper() throws SearchException {
        ISearchParameter text = new Text("java", VacancySearchFields.VACANCY_NAME);
        ISearchParameter area = Area.AREAS.getByName("Санкт-Петербург");
        ISearchParameter profField = ProfField.PROF_FIELDS.getById("1.221");//Программирование
        ISearchParameter salary = new Salary(3000, 5000, Currency.USD);
        ISearchParameter experience = Experience.BETWEEN_3_AND_6;
        ISearchParameter onlyWithSalary = OnlyWithSalary.ON;
        ISearchParameter order = Order.SALARY_DESC;
        ISearchParameter period = new Period(30);
        ISearchParameter schedule = Schedule.FULL_DAY;
        ISearchParameter employment = Employment.FULL;

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
