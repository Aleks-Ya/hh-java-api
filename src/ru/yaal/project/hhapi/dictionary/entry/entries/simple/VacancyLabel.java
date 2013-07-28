package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class VacancyLabel extends AbstractDictionaryEntry implements ISearchParameter {
    public static final VacancyLabel NULL_VACANCY_LABEL = new VacancyLabel();
    public static final IDictionary<VacancyLabel> VACANCY_LABELS = Dictionaries.getInstance().getVacancyLabel();
    public static final VacancyLabel WITH_ADDRESS = VACANCY_LABELS.getById("with_address");
    public static final VacancyLabel ACCEPT_HANDICAPPED = VACANCY_LABELS.getById("accept_handicapped");
    public static final VacancyLabel NOT_FROM_AGENCY = VACANCY_LABELS.getById("not_from_agency");

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.LABEL, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "������ �� ������  ��������";
    }
}
