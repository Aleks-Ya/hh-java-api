package ru.yaal.project.hhapi.dictionary.entry.entries.vacancy;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class VacancySearchOrder extends AbstractDictionaryEntry implements ISearchParameter {
    public static final VacancySearchOrder PUBLICATION_TIME = new VacancySearchOrder("publication_time", "по дате");
    public static final VacancySearchOrder SALARY_DESC = new VacancySearchOrder("salary_desc", "по убыванию зарплаты");
    public static final VacancySearchOrder SALARY_ASC = new VacancySearchOrder("salary_asc", "по возрастанию зарплаты");
    public static final VacancySearchOrder RELEVANCE = new VacancySearchOrder("relevance", "по соответствию");

    public VacancySearchOrder() {
    }

    public VacancySearchOrder(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public SearchParameterBox getSearchParameters() {
        return new SearchParameterBox(SearchParamNames.ORDER_BY, getId());
    }
}
