package ru.yaal.project.hhapi.search;

import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.vacancy.PageableVacancyList;

public class PageableVacancySearch extends AbstractVacancySearch<PageableVacancyList> {
    private int vacanciesLimit;

    public PageableVacancySearch() {
        this(DEFAULT_VACANCIES_LIMIT);
    }

    public PageableVacancySearch(int vacanciesLimit) {
        this.vacanciesLimit = vacanciesLimit;
    }

    @Override
    public PageableVacancyList search() throws SearchException {
        try {
            putParametersToLoader(parameterBox);
            String content = loader.loadContent(UrlConstants.VACANCIES_URL);
            return new PageableVacancyList(parser.parse(content), parameterBox, vacanciesLimit);
        } catch (Exception e) {
            throw new SearchException(e);
        }
    }
}
