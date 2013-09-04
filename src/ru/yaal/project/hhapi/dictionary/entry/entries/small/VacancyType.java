package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Тип вакансии.
 * @see ru.yaal.project.hhapi.dictionary.Constants.VacancyType
 */
public class VacancyType extends AbstractDictionaryEntry {
    public static final VacancyType NULL_VACANCY_TYPE = new VacancyType();

    private VacancyType() {
    }
}
