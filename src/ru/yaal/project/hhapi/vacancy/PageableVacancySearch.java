package ru.yaal.project.hhapi.vacancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.search.SearchException;

public class PageableVacancySearch extends AbstractVacancySearch<PageableVacancyList> {
    private static final Logger LOG = LoggerFactory.getLogger(PageableVacancySearch.class);
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
            putParametersToLoader(getParameterBox());
            String content = getLoader().loadContent(UrlConstants.VACANCIES_URL);
            return new PageableVacancyList(getParser().parse(content), getParameterBox(), vacanciesLimit);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new SearchException(e);
        }
    }
}
