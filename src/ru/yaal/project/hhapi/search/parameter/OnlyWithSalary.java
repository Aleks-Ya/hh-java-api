package ru.yaal.project.hhapi.search.parameter;

import java.util.HashMap;
import java.util.Map;

public class OnlyWithSalary implements ISearchParameter {
    private Map<SearchParamNames, String> params = new HashMap<>(1);

    public OnlyWithSalary() {
        this(true);
    }

    public OnlyWithSalary(boolean withSalary) {
        params.put(SearchParamNames.ONLY_WITH_SALARY, String.valueOf(withSalary));
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() {
        return params;
    }
}
