package ru.yaal.project.hhapi.dictionary.entry.entries.vacancy;

import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class VacancySearchOrder extends AbstractDictionaryEntry implements ISearchParameter {
    public static final VacancySearchOrder NULL_VACANCY_SEARCH_ORDER = new VacancySearchOrder();
    public static final VacancySearchOrder PUBLICATION_TIME = Dictionaries.getVacancySearchOrder().getEntryById("publication_time");
    public static final VacancySearchOrder SALARY_DESC = Dictionaries.getVacancySearchOrder().getEntryById("salary_desc");
    public static final VacancySearchOrder SALARY_ASC = Dictionaries.getVacancySearchOrder().getEntryById("salary_asc");
    public static final VacancySearchOrder RELEVANCE = Dictionaries.getVacancySearchOrder().getEntryById("relevance");

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.ORDER_BY, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Сортировка вакансий";
    }
}
