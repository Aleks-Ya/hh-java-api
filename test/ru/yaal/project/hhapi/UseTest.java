package ru.yaal.project.hhapi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.VacancySearch;

import static org.junit.Assert.assertTrue;

public class UseTest {
    private static final Logger LOG = LoggerFactory.getLogger(UseTest.class);

    /**
     * Проанализируем вакансии программистов java в Москве и Питере.
     */
    @Test
    public void vacancySearch() throws SearchException {
        ISearchParameter text = new Text("java", VacancySearchFields.VACANCY_NAME);
        ISearchParameter area1 = Area.AREAS.getByName("Москва");
//        ISearchParameter area2 = Area.SAINT_PETERSBURG;
//        ISearchParameter metro1 = MetroLine.MOSCOW.getByName("Марьина Роща");
//        ISearchParameter metro2 = MetroLine.SAINT_PETERSBURG.getByName("Чернышевская");
        ISearchParameter profField = ProfField.PROF_FIELDS.getById("1.221");//Программирование
        ISearchParameter salary = new Salary(2000, 5000, Currency.USD);
        ISearchParameter experience = Experience.BETWEEN_3_AND_6;
        ISearchParameter onlyWithSalary = OnlyWithSalary.ON;
        ISearchParameter order = Order.SALARY_DESC;
        ISearchParameter period = new Period(30);
        ISearchParameter schedule = Schedule.FULL_DAY;
        ISearchParameter employment = Employment.FULL;

        ISearch<VacancyList> search = new VacancySearch(50);
        search.addParameter(text)
                .addParameter(area1)
//                .addParameter(area2)
//                .addParameter(metro1)
//                .addParameter(metro2)
                .addParameter(profField)
                .addParameter(salary)
                .addParameter(experience)
                .addParameter(onlyWithSalary)
                .addParameter(period)
                .addParameter(schedule)
                .addParameter(employment)
                .addParameter(order);
        VacancyList vacancies = search.search();
        assertTrue(vacancies.size() > 0);
    }

    @Test
    public void printAllGenders() {
        for (Gender gender : Gender.GENDERS) {
            LOG.info(gender.toString());
        }
    }
}
