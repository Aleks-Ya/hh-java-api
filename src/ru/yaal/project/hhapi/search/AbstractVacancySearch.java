package ru.yaal.project.hhapi.search;

import ru.yaal.project.hhapi.loader.ContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.parser.VacanciesParser;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.PerPage;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;
import ru.yaal.project.hhapi.vacancy.VacancyList;

import java.util.List;
import java.util.Map;

public abstract class AbstractVacancySearch<E> implements ISearch<E> {
    public static final int MAX_VACANCIES_LIMIT = 2000;
    public static final int MIN_VACANCIES_LIMIT = PerPage.MIN_PER_PAGE;
    public static final int DEFAULT_VACANCIES_LIMIT = 20;
    protected IParser<VacancyList> parser = new VacanciesParser();
    protected IContentLoader loader = new ContentLoader();
    protected SearchParameterBox parameterBox = new SearchParameterBox();

    protected void putParametersToLoader(SearchParameterBox parameterBox) {
        Map<SearchParamNames, List<String>> paramMap = parameterBox.getParameterMap();
        for (SearchParamNames key : paramMap.keySet()) {
            for (String value : paramMap.get(key)) {
                loader.addParam(key.getName(), value);
            }
        }
    }

    @Override
    public AbstractVacancySearch<E> addParameter(ISearchParameter searchParameter) throws SearchException {
        parameterBox.addParameter(searchParameter.getSearchParameters());
        return this;
    }

    @Override
    public AbstractVacancySearch<E> addParameter(SearchParameterBox parameterBox) throws SearchException {
        this.parameterBox.addParameter(parameterBox);
        return this;
    }
}
