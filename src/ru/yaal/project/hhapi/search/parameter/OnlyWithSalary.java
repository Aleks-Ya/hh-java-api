package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.SearchException;

public class OnlyWithSalary implements ISearchParameter {
    private boolean onlyWithSalary;

    public OnlyWithSalary() {
        this(true);
    }

    public OnlyWithSalary(boolean withSalary) {
        this.onlyWithSalary = withSalary;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.ONLY_WITH_SALARY, String.valueOf(onlyWithSalary));
    }
}
