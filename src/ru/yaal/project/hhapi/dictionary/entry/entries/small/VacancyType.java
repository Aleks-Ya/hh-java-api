package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * ��� ��������.
 */
public class VacancyType extends AbstractDictionaryEntry {
    public static final VacancyType NULL_VACANCY_TYPE = new VacancyType();
    public static final IDictionary<VacancyType> VACANCY_TYPES = SmallDictionariesInitializer.getInstance().getVacancyType();
    /**
     * ��������.
     */
    public static final VacancyType OPEN = VACANCY_TYPES.getById("open");
    /**
     * ��������.
     */
    public static final VacancyType CLOSED = VACANCY_TYPES.getById("closed");
    /**
     * ���������.
     */
    public static final VacancyType ANONYMOUS = VACANCY_TYPES.getById("anonymous");
    /**
     * � ������ ��������.
     */
    public static final VacancyType DIRECT = VACANCY_TYPES.getById("direct");

    private VacancyType() {
    }
}
