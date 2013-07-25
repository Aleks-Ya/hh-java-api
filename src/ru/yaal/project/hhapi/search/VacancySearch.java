package ru.yaal.project.hhapi.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.vacancy.VacancyList;

class VacancySearch extends AbstractVacancySearch<VacancyList> {
    private static final Logger LOG = LoggerFactory.getLogger(VacancySearch.class);

    @Override
    public VacancyList search() throws SearchException {
        try {
            putParametersToLoader(parameterBox);
            String content = loader.loadContent(UrlConstants.VACANCIES_URL);
            return parser.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new SearchException(e);
        }
    }
}
