package ru.yaal.project.hhapi;

import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.VacancySearch;

import java.util.List;

/**
 * Методы для быстрого поиска вакансий.
 */
public class HhApi {
    public static final int DEFAULT_VACANCY_LIMIT = 25;

    /**
     * Поиск вакансий по параметрам.
     *
     * @param vacancyLimit     Лимит вакансий.
     * @param searchParameters Параметры поиска вакансий.
     */
    public static VacancyList search(int vacancyLimit, ISearchParameter... searchParameters)
            throws SearchException {
        ISearch<VacancyList> search = new VacancySearch(vacancyLimit);
        for (ISearchParameter parameter : searchParameters) {
            search.addParameter(parameter);
        }
        return search.search();
    }

    /**
     * Поиск вакансий по параметрам.
     * Лимит вакансий по-умолчанию ({@value HhApi#DEFAULT_VACANCY_LIMIT}).
     *
     * @param searchParameters Параметры поиска вакансий.
     * @see HhApi#DEFAULT_VACANCY_LIMIT
     */
    public static VacancyList search(ISearchParameter... searchParameters) throws SearchException {
        return search(DEFAULT_VACANCY_LIMIT, searchParameters);
    }

    /**
     * Поиск вакансий по параметрам.
     * Лимит вакансий по-умолчанию ({@value HhApi#DEFAULT_VACANCY_LIMIT}).
     *
     * @param searchParameters Параметры поиска вакансий.
     * @see HhApi#DEFAULT_VACANCY_LIMIT
     */
    public static VacancyList search(List<ISearchParameter> searchParameters) throws SearchException {
        ISearchParameter[] paramArray = (ISearchParameter[]) searchParameters.toArray();
        return search(DEFAULT_VACANCY_LIMIT, paramArray);
    }
}
