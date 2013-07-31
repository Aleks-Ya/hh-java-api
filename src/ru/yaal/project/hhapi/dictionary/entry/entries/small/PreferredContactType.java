package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Желаемый способ связи (резюме).
 */
public final class PreferredContactType extends AbstractDictionaryEntry {
    public static final PreferredContactType NULL_PREFERRED_CONTACT_TYPE = new PreferredContactType();
    public static final IDictionary<PreferredContactType> PREFERRED_CONTACT_TYPES = SmallDictionariesInitializer.getInstance().getPreferredContactType();
    /**
     * Домашний телефон.
     */
    public static final PreferredContactType HOME = PREFERRED_CONTACT_TYPES.getById("home");
    /**
     * Рабочий телефон.
     */
    public static final PreferredContactType WORK = PREFERRED_CONTACT_TYPES.getById("work");
    /**
     * Мобильный телефон.
     */
    public static final PreferredContactType CELL = PREFERRED_CONTACT_TYPES.getById("cell");
    /**
     * Эл. почта.
     */
    public static final PreferredContactType EMAIL = PREFERRED_CONTACT_TYPES.getById("email");

    private PreferredContactType() {
    }

}
