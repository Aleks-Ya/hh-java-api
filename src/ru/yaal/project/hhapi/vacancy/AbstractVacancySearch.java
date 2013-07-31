package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

import java.util.List;
import java.util.Map;

public abstract class AbstractVacancySearch<E> implements ISearch<E> {
    public static final int MAX_VACANCIES_LIMIT = 2000;
    public static final int MIN_VACANCIES_LIMIT = PerPage.MIN_PER_PAGE;
    public static final int DEFAULT_VACANCIES_LIMIT = 20;
    private IParser<VacancyList> parser = new VacanciesParser();
    private IContentLoader loader = ContentLoaderFactory.newInstanceSortTermCache();
    private SearchParameterBox parameterBox = new SearchParameterBox();

    protected IParser<VacancyList> getParser() {
        return parser;
    }

    protected IContentLoader getLoader() {
        return loader;
    }

    protected SearchParameterBox getParameterBox() {
        return parameterBox;
    }

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
