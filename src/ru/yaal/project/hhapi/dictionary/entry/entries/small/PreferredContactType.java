package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Желаемый способ связи (резюме).
 * @see ru.yaal.project.hhapi.dictionary.Constants.PreferredContactType
 */
public final class PreferredContactType extends AbstractDictionaryEntry {
    public static final PreferredContactType NULL_PREFERRED_CONTACT_TYPE = new PreferredContactType();

    private PreferredContactType() {
    }
}
