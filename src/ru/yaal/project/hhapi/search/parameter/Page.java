package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.SearchException;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Page implements ISearchParameter {
    public static final int MIN_PAGE = 1;
    private Integer page;

    public Page(Integer page) throws SearchException {
        setPage(page);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) throws SearchException {
        if (page < MIN_PAGE) throw new SearchException(
                format("����� �������� � ���������� �� ����� ���� ������ %d. ������� %d.", MIN_PAGE, page));
        this.page = page;
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.PAGE, String.valueOf(getPage()));
        return params;
    }

}
