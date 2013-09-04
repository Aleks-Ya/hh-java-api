package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * Только с указанной зарплатой.
 * Может использоваться как параметр поиска вакансий.
 * @see ru.yaal.project.hhapi.dictionary.Constants.OnlyWithSalary
 */
public class OnlyWithSalary implements ISearchParameter {
    private boolean onlyWithSalary;

    public OnlyWithSalary(boolean withSalary) {
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
