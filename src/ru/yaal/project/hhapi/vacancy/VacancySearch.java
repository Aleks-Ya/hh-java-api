package ru.yaal.project.hhapi.vacancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.search.SearchException;

class VacancySearch extends AbstractSearch<VacancyPage> {
    private static final Logger LOG = LoggerFactory.getLogger(VacancySearch.class);

    @Override
    public VacancyPage search() throws SearchException {
        try {
            putParametersToLoader(getParameterBox());
            String content = getLoader().loadContent(UrlConstants.VACANCIES_URL);
            return getParser().parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new SearchException(e);
        }
    }
}
