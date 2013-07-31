package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Область поиска.
 */
public class VacancySearchFields extends AbstractDictionaryEntry {
    public static final VacancySearchFields NULL_VACANCY_SEARCH_FIELD = new VacancySearchFields();
    public static final IDictionary<VacancySearchFields> VACANCY_SEARCH_FIELDS = SmallDictionariesInitializer.getInstance().getVacancySearchFields();
    /**
     * В названии вакансии.
     */
    public static final VacancySearchFields VACANCY_NAME = VACANCY_SEARCH_FIELDS.getById("name");
    /**
     * В названии компании.
     */
    public static final VacancySearchFields COMPANY_NAME = VACANCY_SEARCH_FIELDS.getById("company_name");
    /**
     * В описании вакансии.
     */
    public static final VacancySearchFields DESCRIPTION = VACANCY_SEARCH_FIELDS.getById("description");

    VacancySearchFields() {
    }
}
