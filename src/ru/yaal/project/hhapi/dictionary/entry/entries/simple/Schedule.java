package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class Schedule extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Schedule NULL_SCHEDULE = new Schedule();
    public static final Schedule FULL_DAY = Dictionaries.getSchedule().getEntryById("fullDay");
    public static final Schedule SHIFT = Dictionaries.getSchedule().getEntryById("shift");
    public static final Schedule FLEXIBLE = Dictionaries.getSchedule().getEntryById("flexible");
    public static final Schedule REMOTE = Dictionaries.getSchedule().getEntryById("remote");

    public Schedule() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.SCHEDULE, getId());
    }
}
