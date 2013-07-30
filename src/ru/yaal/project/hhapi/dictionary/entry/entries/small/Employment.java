package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class Employment extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Employment NULL_EMPLOYMENT = new Employment();
    public static final IDictionary<Employment> EMPLOYMENTS = SmallDictionariesInitializer.getInstance().getEmployment();
    public static final Employment FULL = EMPLOYMENTS.getById("full");
    public static final Employment PART = EMPLOYMENTS.getById("part");
    public static final Employment PROJECT = EMPLOYMENTS.getById("project");
    public static final Employment VOLUNTEER = EMPLOYMENTS.getById("volunteer");
    public static final Employment PROBATION = EMPLOYMENTS.getById("probation");

    Employment() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.EMPLOYMENT, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Тип занятости";
    }
}
