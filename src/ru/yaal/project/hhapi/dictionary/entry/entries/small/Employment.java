package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * Тип занятости (вакансия).
 * Может использоваться как параметр поиска вакансий. Допускает множественное значение ("ИЛИ").
 * @see ru.yaal.project.hhapi.dictionary.Constants.Employment
 */
public final class Employment extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Employment NULL_EMPLOYMENT = new Employment();

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
