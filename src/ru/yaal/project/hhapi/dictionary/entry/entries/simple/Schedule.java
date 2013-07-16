package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.util.HashMap;
import java.util.Map;

public class Schedule extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Schedule FULL_DAY = new Schedule("fullDay", "Полный день");
    public static final Schedule SHIFT = new Schedule("shift", "Сменный график");
    public static final Schedule FLEXIBLE = new Schedule("flexible", "Гибкий график");
    public static final Schedule REMOTE = new Schedule("remote", "Удаленная работа");

    public Schedule() {
    }

    public Schedule(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() {
        Map<SearchParamNames, String> searchParams = new HashMap<>(1);
        searchParams.put(SearchParamNames.SCHEDULE, getId());
        return searchParams;
    }
}
