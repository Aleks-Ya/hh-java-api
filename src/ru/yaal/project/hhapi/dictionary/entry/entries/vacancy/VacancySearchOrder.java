package ru.yaal.project.hhapi.dictionary.entry.entries.vacancy;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.util.HashMap;
import java.util.Map;

public class VacancySearchOrder extends AbstractDictionaryEntry implements ISearchParameter {
    public static final VacancySearchOrder PUBLICATION_TIME = new VacancySearchOrder("publication_time", "�� ����");
    public static final VacancySearchOrder SALARY_DESC = new VacancySearchOrder("salary_desc", "�� �������� ��������");
    public static final VacancySearchOrder SALARY_ASC = new VacancySearchOrder("salary_asc", "�� ����������� ��������");
    public static final VacancySearchOrder RELEVANCE = new VacancySearchOrder("relevance", "�� ������������");

    public VacancySearchOrder() {
    }

    public VacancySearchOrder(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.ORDER_BY, getId());
        return params;
    }
}
