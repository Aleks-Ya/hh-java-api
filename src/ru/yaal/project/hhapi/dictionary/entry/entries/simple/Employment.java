package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class Employment extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Employment NULL_EMPLOYMENT = new Employment();
    public static final Employment FULL = Dictionaries.getEmployment().getEntryById("full");
    public static final Employment PART = Dictionaries.getEmployment().getEntryById("part");
    public static final Employment PROJECT = Dictionaries.getEmployment().getEntryById("project");
    public static final Employment VOLUNTEER = Dictionaries.getEmployment().getEntryById("volunteer");
    public static final Employment PROBATION = Dictionaries.getEmployment().getEntryById("probation");

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.EMPLOYMENT, getId());
    }
}
