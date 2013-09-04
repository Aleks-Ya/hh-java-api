package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Готовность к переезду (резюме).
 * @see ru.yaal.project.hhapi.dictionary.Constants.RelocationType
 */
public final class RelocationType extends AbstractDictionaryEntry {
    public static final RelocationType NULL_RELOCATION_TYPE = new RelocationType();

    private RelocationType() {
    }
}
