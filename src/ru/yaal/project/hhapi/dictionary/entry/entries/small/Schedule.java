package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class Schedule extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Schedule NULL_SCHEDULE = new Schedule();
    public static final IDictionary<Schedule> SCHEDULES = SmallDictionariesInitializer.getInstance().getSchedule();
    public static final Schedule FULL_DAY = SCHEDULES.getById("fullDay");
    public static final Schedule SHIFT = SCHEDULES.getById("shift");
    public static final Schedule FLEXIBLE = SCHEDULES.getById("flexible");
    public static final Schedule REMOTE = SCHEDULES.getById("remote");

    Schedule() {
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
