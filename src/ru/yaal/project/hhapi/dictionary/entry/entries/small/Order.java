package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * Сортировка списка вакансий.
 * @see ru.yaal.project.hhapi.dictionary.Constants.Order
 */
public final class Order extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Order NULL_ORDER = new Order();

    private Order() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.ORDER_BY, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Сортировка вакансий";
    }
}
