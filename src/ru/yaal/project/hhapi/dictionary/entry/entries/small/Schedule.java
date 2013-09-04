package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * График работы.
 * Может использоваться как параметр поиска вакансий. Допускает множественное значение ("ИЛИ").
 * @see ru.yaal.project.hhapi.dictionary.Constants.Schedule
 */
public final class Schedule extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Schedule NULL_SCHEDULE = new Schedule();

    private Schedule() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.SCHEDULE, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "График работы";
    }
}
