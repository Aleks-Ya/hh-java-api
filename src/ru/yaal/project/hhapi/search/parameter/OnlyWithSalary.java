package ru.yaal.project.hhapi.search.parameter;

import java.util.HashMap;
import java.util.Map;

public class OnlyWithSalary implements ISearchParameter {
    private static final String ONLY_WITH_SALARY_PARAM_NAME = "only_with_salary";
    private Map<String, String> params = new HashMap<>(1);

    public OnlyWithSalary() {
        this(true);
    }

    public OnlyWithSalary(boolean withSalary) {
        params.put(ONLY_WITH_SALARY_PARAM_NAME, String.valueOf(withSalary));
    }

    @Override
    public Map<String, String> getSearchParameters() {
        return params;
    }
}
