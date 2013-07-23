package ru.yaal.project.hhapi.search;

import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.vacancy.VacancyList;

public class VacanciesSearch extends AbstractVacancySearch<VacancyList> {
    @Override
    public VacancyList search() throws SearchException {
        try {
            putParametersToLoader(parameterBox);
            String content = loader.loadContent(UrlConstants.VACANCIES_URL);
            return parser.parse(content);
        } catch (Exception e) {
            throw new SearchException(e);
        }
    }
}
