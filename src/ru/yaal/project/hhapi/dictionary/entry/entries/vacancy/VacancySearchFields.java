package ru.yaal.project.hhapi.dictionary.entry.entries.vacancy;

import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class VacancySearchFields extends AbstractDictionaryEntry {
    public static final VacancySearchFields NULL_VACANCY_SEARCH_FIELD = new VacancySearchFields();
    public static final VacancySearchFields VACANCY_NAME = Dictionaries.getInstance().getVacancySearchFields().getById("name");
    public static final VacancySearchFields COMPANY_NAME = Dictionaries.getInstance().getVacancySearchFields().getById("company_name");
    public static final VacancySearchFields DESCRIPTION = Dictionaries.getInstance().getVacancySearchFields().getById("description");

    VacancySearchFields() {
    }
}
