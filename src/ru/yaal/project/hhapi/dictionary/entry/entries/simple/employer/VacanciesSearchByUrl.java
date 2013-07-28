package ru.yaal.project.hhapi.dictionary.entry.entries.simple.employer;

import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.IterableVacancyList;
import ru.yaal.project.hhapi.search.IterableVacancySearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

@Deprecated
public class VacanciesSearchByUrl implements ISearch<IterableVacancyList> {
    private IterableVacancySearch search;

    public VacanciesSearchByUrl() throws SearchException {
        search = new IterableVacancySearch(IterableVacancySearch.MAX_VACANCIES_LIMIT);
    }

    @Override
    public IterableVacancyList search() throws SearchException {
        return search.search();
    }

    @Override
    public ISearch<IterableVacancyList> addParameter(ISearchParameter parameter) throws SearchException {
        return search.addParameter(parameter);
    }

    @Override
    public ISearch<IterableVacancyList> addParameter(SearchParameterBox parameterBox) throws SearchException {
        return search.addParameter(parameterBox);
    }
}
