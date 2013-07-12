package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchOrder;
import ru.yaal.project.hhapi.search.SearchException;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

@Deprecated
public class PageAndPerPageAndOrder implements ISearchParameter {
    public static final int MIN_PER_PAGE = 1;
    public static final int MAX_PER_PAGE = 500;
    public static final int DEFAULT_PER_PAGE = 20;
    public static final int MIN_PAGE = 1;
    public static final int MAX_VACANCIES = 2000;
    private Integer perPage;
    private Integer page;
    private VacancySearchOrder vacancySearchOrder;

    public PageAndPerPageAndOrder(Integer page, Integer perPage, VacancySearchOrder vacancySearchOrder) throws SearchException {
        setPage(page);
        setPerPage(perPage);
        setVacancySearchOrder(vacancySearchOrder);
    }

    public PageAndPerPageAndOrder(Integer page, Integer perPage) throws SearchException {
        this(page, perPage, null);
    }

    public PageAndPerPageAndOrder(Integer page) throws SearchException {
        this(page, DEFAULT_PER_PAGE, null);
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) throws SearchException {
        if (perPage < MIN_PER_PAGE || perPage > MAX_PER_PAGE)
            throw new SearchException(
                    format("Некорректное количество найденных элементов на страницу. Ожидается %d-%d. Получено %d",
                            MIN_PER_PAGE, MAX_PER_PAGE, perPage));
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) throws SearchException {
        if (page < MIN_PAGE) throw new SearchException(
                format("Номер страницы с вакансиями не может быть меньше %d. Получен %d.", MIN_PAGE, page));
        this.page = page;
    }

    public VacancySearchOrder getVacancySearchOrder() {
        return vacancySearchOrder;
    }

    public void setVacancySearchOrder(VacancySearchOrder vacancySearchOrder) {
        if (vacancySearchOrder != null) {
            this.vacancySearchOrder = vacancySearchOrder;
        } else {
            this.vacancySearchOrder = VacancySearchOrder.PUBLICATION_TIME;
        }
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        verifyVacancyCount();
        Map<SearchParamNames, String> params = new HashMap<>(3);
        params.put(SearchParamNames.PAGE, String.valueOf(getPage()));
        params.put(SearchParamNames.PER_PAGE, String.valueOf(getPerPage()));
        params.put(SearchParamNames.ORDER_BY, String.valueOf(getVacancySearchOrder().getId()));
        return params;
    }

    private void verifyVacancyCount() throws SearchException {
        int vacanciesCount = getPerPage() * getPage();
        if (vacanciesCount > MAX_VACANCIES) throw
                new SearchException(
                        format("Максимальное количество вакансий в результате запроса %d. Попытка получить %d.",
                                MAX_VACANCIES, vacanciesCount));
    }
}
