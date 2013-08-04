package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

public class OnlyWithSalary implements ISearchParameter {
    public static final OnlyWithSalary ON = new OnlyWithSalary(true);
    public static final OnlyWithSalary OFF = new OnlyWithSalary(false);
    private boolean onlyWithSalary;

    private OnlyWithSalary(boolean withSalary) {
        this.onlyWithSalary = withSalary;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.ONLY_WITH_SALARY, String.valueOf(onlyWithSalary));
    }

    @Override
    public String getSearchParameterName() {
        return "Только с указанием зарплаты";
    }
}
