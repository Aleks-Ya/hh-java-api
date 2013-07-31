package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

/**
 * Сортировка списка вакансий.
 */
public class Order extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Order NULL_ORDER = new Order();
    public static final IDictionary<Order> ORDERS = SmallDictionariesInitializer.getInstance().getOrder();
    /**
     * По дате.
     */
    public static final Order PUBLICATION_TIME = ORDERS.getById("publication_time");
    /**
     * По убыванию зарплаты.
     */
    public static final Order SALARY_DESC = ORDERS.getById("salary_desc");
    /**
     * По возрастанию зарплаты.
     */
    public static final Order SALARY_ASC = ORDERS.getById("salary_asc");
    /**
     * По соответствию.
     */
    public static final Order RELEVANCE = ORDERS.getById("relevance");

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
