package ru.yaal.project.hhapi.search;

import ru.yaal.project.hhapi.search.parameter.PerPage;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.PageableVacancyList;

import java.util.Set;

public class IterableVacancySearch extends AbstractVacancySearch<IterableVacancyList> {
    private Integer vacancyLimit;

    public IterableVacancySearch(int vacancyLimit) throws SearchException {
        if (vacancyLimit < MIN_VACANCIES_LIMIT || vacancyLimit > MAX_VACANCIES_LIMIT) throw new SearchException(
                "Количество вакансий может быть в пределах от %d до %d. Получено: %d.",
                MIN_VACANCIES_LIMIT, MAX_VACANCIES_LIMIT, vacancyLimit);
        this.vacancyLimit = vacancyLimit;
    }

    @Override
    public IterableVacancyList search() throws SearchException {
        verifySearchParameters(parameterBox);
        if (vacancyLimit <= PerPage.MAX_PER_PAGE) {
            addParameter(new PerPage(vacancyLimit));
        } else {
            addParameter(new PerPage(PerPage.MAX_PER_PAGE));
        }
        try {
            ISearch<PageableVacancyList> search = new PageableVacancySearch(vacancyLimit);
            search.addParameter(parameterBox);
            PageableVacancyList pageableVacancyList = search.search();
            return new IterableVacancyList(pageableVacancyList);
        } catch (Exception e) {
            throw new SearchException(e);
        }
    }

    private void verifySearchParameters(SearchParameterBox parameterBox) throws SearchException {
        Set<SearchParamNames> keys = parameterBox.getParameterMap().keySet();
        for (SearchParamNames name : keys) {
            if (name == SearchParamNames.PAGE)
                throw new SearchException("В IterableVacancySearch нельзя задавать номер страницы.");
            if (name == SearchParamNames.PER_PAGE)
                throw new SearchException("В IterableVacancySearch нельзя задавать количество вакансий на страницу.");
        }

    }
}
