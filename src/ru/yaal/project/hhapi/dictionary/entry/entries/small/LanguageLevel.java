package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Уровень владения языком (резюме).
 * @see ru.yaal.project.hhapi.dictionary.Constants.LanguageLevel
 */
public final class LanguageLevel extends AbstractDictionaryEntry {
    public static final LanguageLevel NULL_LANGUAGE_LEVEL = new LanguageLevel();

    private LanguageLevel() {
    }
}
