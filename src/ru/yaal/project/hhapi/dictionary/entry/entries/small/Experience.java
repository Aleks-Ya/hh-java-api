package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * Опыт работы (вакансия).
 */
public final class Experience extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Experience NULL_EXPERIENCE = new Experience();

    private Experience() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.EXPERIENCE, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Опыт работы";
    }
}
