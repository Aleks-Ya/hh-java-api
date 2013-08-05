package ru.yaal.project.hhapi;

import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestHelper {
    public static final int DEFAULT_VACANCY_LIMIT = 25;

    /**
     * Метод для быстрого поиска вакансий по параметрам.
     * Дополнительно проверяется равенство количества найденных вакансий заданному лимиту.
     */
    public static IterableVacancyList search(int vacancyLimit, ISearchParameter... searchParameters)
            throws SearchException {
        ISearch<IterableVacancyList> search = new IterableVacancySearch(vacancyLimit);
        for (ISearchParameter parameter : searchParameters) {
            search.addParameter(parameter);
        }
        IterableVacancyList vacancies = search.search();
        assertEquals(vacancyLimit, vacancies.size());
        return vacancies;
    }

    public static IterableVacancyList search(ISearchParameter... searchParameters) throws SearchException {
        return search(DEFAULT_VACANCY_LIMIT, searchParameters);
    }

    public static IterableVacancyList search(List<ISearchParameter> searchParameters) throws SearchException {
        ISearchParameter[] paramArray = (ISearchParameter[]) searchParameters.toArray();
        return search(DEFAULT_VACANCY_LIMIT, paramArray);
    }
}
