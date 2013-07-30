package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class VacancySearchFields extends AbstractDictionaryEntry {
    public static final VacancySearchFields NULL_VACANCY_SEARCH_FIELD = new VacancySearchFields();
    public static final IDictionary<VacancySearchFields> VACANCY_SEARCH_FIELDS = SmallDictionariesInitializer.getInstance().getVacancySearchFields();
    public static final VacancySearchFields VACANCY_NAME = VACANCY_SEARCH_FIELDS.getById("name");
    public static final VacancySearchFields COMPANY_NAME = VACANCY_SEARCH_FIELDS.getById("company_name");
    public static final VacancySearchFields DESCRIPTION = VACANCY_SEARCH_FIELDS.getById("description");

    VacancySearchFields() {
    }
}
