package ru.yaal.project.hhapi;

import org.junit.Ignore;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Employment;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Experience;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Schedule;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.VacanciesList;
import ru.yaal.project.hhapi.search.VacanciesSearch;
import ru.yaal.project.hhapi.search.parameter.PerPage;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.Vacancy;

public class UsabilityTest {
    @Test
    @Ignore
    public void test() throws SearchException, DictionaryException, LoadException, ParseException {
        /*условия поиска: текст "java" (искать в названии и описании вакансии), специализция "IT", зарплата 70-100 т.р., регион: СПб,
        полная занятость, полный рабочий день,
        * опыт работы 3-6 лет*/
        final ProfessionalField programmingArea = Dictionaries.getProfessionalField().getEntryById("1.221");
        final Area spb = Dictionaries.getArea().getEntryByName("Санкт-Петербург");
        ISearch<VacanciesList> search = new VacanciesSearch();
        search
                .addParameter(new Text("java", VacancySearchFields.VACANCY_NAME, VacancySearchFields.DESCRIPTION))
                .addParameter(programmingArea)
                .addParameter(new Salary(70000, 100000))
                .addParameter(spb)
                .addParameter(Employment.FULL)
                .addParameter(Schedule.FULL_DAY)
                .addParameter(Experience.BETWEEN_3_AND_6)
                .addParameter(new PerPage(200));
        VacanciesList result = search.search();
        int git = 0;
        int svn = 0;
        int d = 0;
        for (Vacancy vacancy : result.getItems()) {
            String description = vacancy.getDescription();
            if (description != null && !description.isEmpty()) d++;
            if (description != null && description.toUpperCase().contains(" GIT")) git++;
            if (description != null && description.toUpperCase().contains(" SVN")) svn++;
        }
        System.out.printf("Git = %d\n", git);
        System.out.printf("Svn = %d\n", svn);
        System.out.printf("d = %d", d);
    }
}
