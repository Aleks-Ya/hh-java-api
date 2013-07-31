package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

public class EmployerSearchParameter extends AbstractDictionaryEntry implements ISearchParameter {
    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.EMPLOYER, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Идентификатор компании";
    }
}
