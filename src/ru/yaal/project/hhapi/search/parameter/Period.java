package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.SearchException;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Period implements ISearchParameter {
    public static final int MIN_PERIOD = 1;
    public static final int MAX_PERIOD = 30;
    private Integer period;

    public Period(Integer period) throws SearchException {
        setPeriod(period);
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.PERIOD, String.valueOf(getPeriod()));
        return params;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) throws SearchException {
        if (period < MIN_PERIOD || period > MAX_PERIOD) throw new SearchException(
                format("Некорректный период. Ожидается %d-%d. Получено %d.", MIN_PERIOD, MAX_PERIOD, period));
        this.period = period;
    }
}
