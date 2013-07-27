package ru.yaal.project.hhapi.dictionary.entry.entries.vacancy;

import ru.yaal.project.hhapi.dictionary.Dictionaries2;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class Order extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Order NULL_ORDER = new Order();
    public static final Order PUBLICATION_TIME = Dictionaries2.getInstance().getOrder().getById("publication_time");
    public static final Order SALARY_DESC = Dictionaries2.getInstance().getOrder().getById("salary_desc");
    public static final Order SALARY_ASC = Dictionaries2.getInstance().getOrder().getById("salary_asc");
    public static final Order RELEVANCE = Dictionaries2.getInstance().getOrder().getById("relevance");

    Order() {
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
