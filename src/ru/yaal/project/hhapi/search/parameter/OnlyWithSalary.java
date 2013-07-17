package ru.yaal.project.hhapi.search.parameter;

public class OnlyWithSalary implements ISearchParameter {
    private boolean onlyWithSalary;

    public OnlyWithSalary() {
        this(true);
    }

    public OnlyWithSalary(boolean withSalary) {
        this.onlyWithSalary = withSalary;
    }

    @Override
    public SearchParameterBox getSearchParameters() {
        return new SearchParameterBox(SearchParamNames.ONLY_WITH_SALARY, String.valueOf(onlyWithSalary));
    }
}
