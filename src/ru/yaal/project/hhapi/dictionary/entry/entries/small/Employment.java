package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

/**
 * Тип занятости (вакансия).
 */
public class Employment extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Employment NULL_EMPLOYMENT = new Employment();
    public static final IDictionary<Employment> EMPLOYMENTS = SmallDictionariesInitializer.getInstance().getEmployment();
    /**
     * Полная занятость.
     */
    public static final Employment FULL = EMPLOYMENTS.getById("full");
    /**
     * Частичная занятость.
     */
    public static final Employment PART = EMPLOYMENTS.getById("part");
    /**
     * Проектная работа.
     */
    public static final Employment PROJECT = EMPLOYMENTS.getById("project");
    /**
     * Волонтерство.
     */
    public static final Employment VOLUNTEER = EMPLOYMENTS.getById("volunteer");
    /**
     * Стажировка.
     */
    public static final Employment PROBATION = EMPLOYMENTS.getById("probation");

    private Employment() {
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
