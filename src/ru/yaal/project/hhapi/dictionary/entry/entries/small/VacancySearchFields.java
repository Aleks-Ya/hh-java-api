package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Область поиска.
 * Может использоваться как параметр поиска вакансий. Допускает множественное значение ("ИЛИ").
 */
public final class VacancySearchFields extends AbstractDictionaryEntry {
    public static final VacancySearchFields NULL_VACANCY_SEARCH_FIELD = new VacancySearchFields();

    private VacancySearchFields() {
    }
}
