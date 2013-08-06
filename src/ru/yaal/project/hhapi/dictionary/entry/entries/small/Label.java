package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * ����� ��������.
 * ����� �������������� ��� �������� ������ ��������. ��������� ������������� �������� ("�").
 */
public final class Label extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Label NULL_LABEL = new Label();
    public static final IDictionary<Label> LABELS = SmallDictionariesInitializer.getInstance().getLabel();
    /**
     * ������ � �������.
     */
    public static final Label WITH_ADDRESS = LABELS.getById("with_address");
    /**
     * ������ ��������� ��� ����� � �������������.
     */
    public static final Label ACCEPT_HANDICAPPED = LABELS.getById("accept_handicapped");
    /**
     * ��� �������� ��������.
     */
    public static final Label NOT_FROM_AGENCY = LABELS.getById("not_from_agency");

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
