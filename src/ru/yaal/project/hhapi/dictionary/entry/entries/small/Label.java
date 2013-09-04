package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * ����� ��������.
 * ����� �������������� ��� �������� ������ ��������. ��������� ������������� �������� ("�").
 * @see ru.yaal.project.hhapi.dictionary.Constants.Label
 */
public final class Label extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Label NULL_LABEL = new Label();

    private Label() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.LABEL, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "������ �� ������  ��������";
    }
}
