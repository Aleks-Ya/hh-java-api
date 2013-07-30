package ru.yaal.project.hhapi.vacancy;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.INullable;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;


@Data
final public class Salary implements ISearchParameter, INullable {
    public static final Salary NULL_SALARY = new Salary();
    private static final Integer NULL_VALUE = -1;
    private Integer from;
    private Integer to;
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Currency currency = Currency.NULL_CURRENCY;

    public Salary() {
        this(NULL_VALUE, NULL_VALUE);
    }

    public Salary(Integer from, Integer to) {
        this(from, to, Currency.RUR);
    }

    public Salary(Integer from, Integer to, Currency currency) {
        setFrom(from);
        setTo(to);
        setCurrency(currency);
    }

    /**
     * Конвертирует зарплату, указанную в произвольной валюте, в рубли.
     */
    public static Salary toRur(Salary salary) {
        Salary salaryRur = new Salary();
        Currency currency = salary.getCurrency();

        Integer from = salary.getFrom();
        Integer fromRur = (from != null) ? new Double(from / currency.getRate()).intValue() : null;
        salaryRur.setFrom(fromRur);

        Integer to = salary.getTo();
        Integer toRur = (to != null) ? new Double(to / currency.getRate()).intValue() : null;
        salaryRur.setTo(toRur);

        salaryRur.setCurrency(Currency.RUR);

        return salaryRur;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        SearchParameterBox params = new SearchParameterBox();
        if (from != null) {
            params.addParameter(SearchParamNames.SALARY, String.valueOf(from));
        } else {
            if (to != null) {
                params.addParameter(SearchParamNames.SALARY, String.valueOf(to));
            } else {
                throw new SearchException("Ни минимальная, ни максимальная зарплата не указана.");
            }
        }
        params.setParameter(SearchParamNames.CURRENCY, getCurrency().getId());
        return params;
    }

    @Override
    public boolean isNull() {
        return ((getTo() == null && getFrom() == null) || NULL_VALUE.equals(getTo()) || NULL_VALUE.equals(getFrom()));
    }

    @Override
    public String getSearchParameterName() {
        return "Зарплата";
    }
}
