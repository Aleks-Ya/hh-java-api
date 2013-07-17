package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class Schedule extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Schedule NULL_SCHEDULE = new Schedule();
    public static final Schedule FULL_DAY = new Schedule("fullDay", "Полный день");
    public static final Schedule SHIFT = new Schedule("shift", "Сменный график");
    public static final Schedule FLEXIBLE = new Schedule("flexible", "Гибкий график");
    public static final Schedule REMOTE = new Schedule("remote", "Удаленная работа");

    public Schedule() {
    }

    public Schedule(String id, String name) {
        super(id, name);
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.SCHEDULE, getId());
    }
}
