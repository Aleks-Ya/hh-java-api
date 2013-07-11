package ru.yaal.project.hhapi.search;

import ru.yaal.project.hhapi.HhConstants;
import ru.yaal.project.hhapi.loader.ContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.parser.VacancyParser;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.util.Map;

public class VacanciesSearch implements ISearch<VacanciesList> {
    private IContentLoader loader = new ContentLoader();

    @Override
    public VacanciesList search() throws SearchException {
        try {
            String content = loader.loadContent(HhConstants.VACANCIES_URL);
            IParser<VacanciesList> parser = new VacancyParser();
            return parser.parse(content);
        } catch (LoadException e) {
            throw new SearchException(e);
        }
    }

    @Override
    public VacanciesSearch addParameter(ISearchParameter searchParameter) {
        Map<SearchParamNames, String> paramMap = searchParameter.getSearchParameters();
        for (SearchParamNames key : paramMap.keySet()) {
            loader.addParam(key.getName(), paramMap.get(key));
        }
        return this;
    }
}
