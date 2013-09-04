package ru.yaal.project.hhapi;

import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.VacancySearch;

import java.util.List;

/**
 * ������ ��� �������� ������ ��������.
 */
public class HhApi {
    public static final int DEFAULT_VACANCY_LIMIT = 25;

    /**
     * ����� �������� �� ����������.
     *
     * @param vacancyLimit     ����� ��������.
     * @param searchParameters ��������� ������ ��������.
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
     * ����� �������� �� ����������.
     * ����� �������� ��-��������� ({@value HhApi#DEFAULT_VACANCY_LIMIT}).
     *
     * @param searchParameters ��������� ������ ��������.
     * @see HhApi#DEFAULT_VACANCY_LIMIT
     */
    public static VacancyList search(ISearchParameter... searchParameters) throws SearchException {
        return search(DEFAULT_VACANCY_LIMIT, searchParameters);
    }

    /**
     * ����� �������� �� ����������.
     * ����� �������� ��-��������� ({@value HhApi#DEFAULT_VACANCY_LIMIT}).
     *
     * @param searchParameters ��������� ������ ��������.
     * @see HhApi#DEFAULT_VACANCY_LIMIT
     */
    public static VacancyList search(List<ISearchParameter> searchParameters) throws SearchException {
        ISearchParameter[] paramArray = (ISearchParameter[]) searchParameters.toArray();
        return search(DEFAULT_VACANCY_LIMIT, paramArray);
    }
}
